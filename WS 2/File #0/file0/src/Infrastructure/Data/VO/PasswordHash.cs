using Core.Domain.VO;
using Infrastructure.Data.Utils;

namespace Infrastructure.Data.VO
{
    /// <inheritdoc/>
    public class PasswordHash : IPassword
    {
        /// <summary>
        ///     Initializes a new instance of the <see cref="PasswordHash"/>
        ///     class.
        /// </summary>
        /// <param name="value">The hashed value.</param>
        private PasswordHash(string value)
        {
            Value = value;
        }

        /// <inheritdoc/>
        public string Value { get; }

        /// <inheritdoc/>
        public bool IsEqual(string password)
        {
            return Pbkdf2PasswordHasher.IsMatch(password, Value);
        }

        /// <summary>
        ///     Creates a new <see cref="PasswordHash"/> instance from the
        ///     specified <paramref name="plainText"/>.
        /// </summary>
        /// <param name="plainText">The plain text password.</param>
        /// <returns>A new <see cref="PasswordHash"/></returns>
        public static PasswordHash FromPlainText(string plainText)
        {
            return new PasswordHash(Pbkdf2PasswordHasher.Hash(plainText));
        }

        /// <summary>
        ///     Creates a new <see cref="PasswordHash"/> instance from the
        ///     specified <paramref name="hash"/>.
        /// </summary>
        /// <param name="hash">The hashed password.</param>
        /// <returns>A new <see cref="PasswordHash"/></returns>
        public static PasswordHash With(string hash)
        {
            return new PasswordHash(hash);
        }
    }
}
