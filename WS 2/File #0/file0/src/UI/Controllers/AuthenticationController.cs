using System.Threading.Tasks;
using Infrastructure.Identity;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;
using UI.View.Authentication;
using UI.View.Shared;

namespace UI.Controllers
{
    /// <summary>
    ///     Handles any requests relating to the authentication process, i.e.
    ///     sign in and sign out.
    /// </summary>
    [Controller, Route]
    public class AuthenticationController
    {
        /// <summary>
        ///     The authentication manager.
        /// </summary>
        private readonly IAuthenticationManager _manager;

        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="AuthenticationController"/> class.
        /// </summary>
        /// <param name="service">The authentication manager.</param>
        public AuthenticationController(IAuthenticationManager manager)
        {
            _manager = manager;
        }

        /// <summary>
        ///     Authenticates a user with their credentials (user/password) as
        ///     well as an optional 2FA code if 2FA is enabled.
        /// </summary>
        /// <param name="username">The user name.</param>
        /// <param name="password">The password.</param>
        /// <param name="code">The 2FA code (optional).</param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Login")]
        public async Task<IView> Login(
            [Parameter("u"), Description("username")] string username,
            [Parameter("p"), Description("password")] string password,
            [Parameter("c"), Description("2fa code")] string code = null)
        {
            var result = await _manager.Authenticate(username, password, code);
            if (!result.IsSuccess)
            {
                return new ErrorView(result.ErrorMessage);
            }
            return new LoggedInView(username);
        }

        /// <summary>
        ///     Signs out a user from the application.
        /// </summary>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Secured]
        [Description("Logout")]
        public async Task<IView> Logout()
        {
            await _manager.SignOut();
            return new LoggedOutView();
        }

        /// <summary>
        ///     Returns a link to a QR code to register 2FA.
        /// </summary>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Secured]
        [Description("Setup 2FA")]
        public async Task<IView> Setup2Fa()
        {
            var link = await _manager.Setup2Fa();
            return new SetupTfaView(link);
        }

        /// <summary>
        ///     Enables 2FA for the current logged in user.
        /// </summary>
        /// <param name="code">The verification code.</param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Secured]
        [Description("Enable 2FA")]
        public async Task<IView> Enable2Fa(
            [Parameter("c"), Description("verification code")] string code)
        {
            await _manager.Enable2Fa(code);
            return new TfaEnabledView();
        }
    }
}
