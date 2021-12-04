namespace UI.Models
{
    /// <summary>
    ///     A user view model.
    /// </summary>
    public sealed class UserViewModel
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="UserViewModel"/> class.
        /// </summary>
        /// <param name="id">The user id.</param>
        /// <param name="username">The user name.</param>
        /// <param name="passwordHash">The password hash.</param>
        /// <param name="is2FaEnabled">If 2FA is enabled</param>
        public UserViewModel(
            int id,
            string username,
            string passwordHash,
            bool is2FaEnabled)
        {
            Id = id;
            Username = username;
            PasswordHash = passwordHash;
            Is2FaEnabled = is2FaEnabled;
        }

        /// <summary>
        ///     Gets the user id.
        /// </summary>
        public int Id { get; }

        /// <summary>
        ///     Gets the user name.
        /// </summary>
        public string Username { get; }

        /// <summary>
        ///     Gets the password hash.
        /// </summary>
        public string PasswordHash { get; }

        /// <summary>
        ///     Gets whether or not 2FA is enabled.
        /// </summary>
        public bool Is2FaEnabled { get; }
    }
}
