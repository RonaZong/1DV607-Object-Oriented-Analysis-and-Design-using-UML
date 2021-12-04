namespace Core.Domain.VO
{
    /// <summary>
    ///     Represents a 2FA configuration.
    /// </summary>
    public interface ITwoFactor
    {
        /// <summary>
        ///     Returns whether or not 2FA is enabled.
        /// </summary>
        bool IsEnabled { get; }

        /// <summary>
        ///     The 2FA secret.
        /// </summary>
        string Secret { get; }
    }
}
