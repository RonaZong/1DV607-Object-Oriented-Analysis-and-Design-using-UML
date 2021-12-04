using System;
using System.Collections.Generic;
using System.Linq;
using System.Security;
using System.Security.Principal;
using System.Threading.Tasks;
using Core.Domain.Entities;
using Infrastructure.Data;
using Infrastructure.Data.VO;
using Infrastructure.Session.Abstractions;
using Microsoft.EntityFrameworkCore;
using TwoFactorAuthNet;

namespace Infrastructure.Identity
{
    public interface IAuthenticationManager
    {
        Task<AuthenticationResult> Authenticate(
            string username, string password, string code = null);

        Task SignOut();

        Task<string> Setup2Fa();

        Task Enable2Fa(string code);
    }

    public interface IUserManager
    {
        Task<IEnumerable<User>> List();
    }

    public class AuthenticationManager : IAuthenticationManager
    {
        private readonly YachtClubContext _context;
        private readonly TwoFactorAuth _tfa;
        private readonly ISession _session;
        public AuthenticationManager(
            YachtClubContext context,
            ISession session,
            TwoFactorAuth tfa)
        {
            _context = context;
            _session = session;
            _tfa = tfa;
        }

        /// <inheritdoc/>
        public async Task<AuthenticationResult> Authenticate(
            string username, string password, string code = null)
        {
            var user = await _context.Users
                .Where(user => user.Username == username)
                .SingleOrDefaultAsync();
            if (user == null || !user.Password.IsEqual(password))
            {
                return AuthenticationResult.Failed("Invalid credentials");
            }
            if (user.TwoFactor?.IsEnabled == true)
            {
                if (string.IsNullOrWhiteSpace(code))
                {
                    return AuthenticationResult.Failed("2FA code missing");
                }
                if (!_tfa.VerifyCode(user.TwoFactor.Secret, code))
                {
                    return AuthenticationResult.Failed("Invalid 2FA code");
                }
            }
            _session.User = new GenericPrincipal(
                new GenericIdentity(user.Username), new string[] { });
            return AuthenticationResult.Success();
        }

        /// <inheritdoc/>
        public async Task Enable2Fa(string code)
        {
            var user = await _context.Users
                .Where(user => user.Username == _session.User.Identity.Name)
                .SingleAsync();
            var secret = user.TwoFactor.Secret;
            if (!_tfa.VerifyCode(secret, code))
            {
                throw new SecurityException("code not verified");
            }
            user.TwoFactor = new TwoFactor(true, secret);
            _context.Update(user);
            await _context.SaveChangesAsync();
        }

        /// <inheritdoc/>
        public async Task<string> Setup2Fa()
        {
            var user = await _context.Users
                .Where(user => user.Username == _session.User.Identity.Name)
                .SingleAsync();
            var secret = _tfa.CreateSecret(160);
            user.TwoFactor = new TwoFactor(secret);
            _context.Update(user);
            await _context.SaveChangesAsync();
            return  _tfa.GetQrCodeImageAsDataUri(user.Username, secret);
        }

        /// <inheritdoc/>
        public Task SignOut()
        {
            _session.User = PrincipalUtils.Anonymous();
            return Task.CompletedTask;
        }
    }

    public class UserManager : IUserManager
    {
        private readonly YachtClubContext _context;

        public UserManager(YachtClubContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<User>> List()
        {
            return await _context.Users.ToListAsync();
        }
    }

    public class AuthenticationResult
    {
        public AuthenticationResult(bool isSuccess, string errorMessage)
        {
            IsSuccess = isSuccess;
            ErrorMessage = errorMessage;
        }
        public bool IsSuccess { get; }
        public string ErrorMessage { get; }
        public static AuthenticationResult Success()
        {
            return new AuthenticationResult(true, null);
        }
        public static AuthenticationResult Failed(string message)
        {
            return new AuthenticationResult(false, message);
        }
    }
}
