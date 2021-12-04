using Core.Domain.VO;

namespace Infrastructure.Data.VO
{
    /// <inheritdoc/>
    public class TwoFactor : ITwoFactor
    {
        /// <summary>
        ///     Initializes a new instance of the <see cref="TwoFactor"/>
        ///     class.
        /// </summary>
        /// <param name="secret">The 2FA secret.</param>
        public TwoFactor(string secret)
        {
            IsEnabled = false;
            Secret = secret;
        }

        /// <summary>
        ///     Initializes a new instance of the <see cref="TwoFactor"/>
        ///     class.
        /// </summary>
        /// <param name="isEnabled">If 2FA is enabled.</param>
        /// <param name="secret">The 2FA secret.</param>
        public TwoFactor(bool isEnabled, string secret)
        {
            IsEnabled = isEnabled;
            Secret = secret;
        }

        /// <inheritdoc/>
        public bool IsEnabled { get; }

        /// <inheritdoc/>
        public string Secret { get; }
    }
}
