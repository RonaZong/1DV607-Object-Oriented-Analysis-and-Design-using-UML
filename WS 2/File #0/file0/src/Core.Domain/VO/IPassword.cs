namespace Core.Domain.VO
{
    /// <summary>
    ///     Represents a password.
    /// </summary>
    public interface IPassword
    {
        /// <summary>
        ///     The password value.
        /// </summary>
        string Value { get; }

        /// <summary>
        ///     Returns whether or not this password is equal to the specified
        ///     <paramref name="password"/>.
        /// </summary>
        /// <param name="password">
        ///     The plain text password to check for equality.
        /// </param>
        /// <returns>
        ///     <c>true</c> if they match; <c>false</c> otherwise.
        /// </returns>
        bool IsEqual(string password);
    }
}
