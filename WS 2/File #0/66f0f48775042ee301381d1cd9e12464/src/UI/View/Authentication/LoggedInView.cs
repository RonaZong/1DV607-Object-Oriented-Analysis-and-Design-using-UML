using UI.View.Shared;

namespace UI.View.Authentication
{
    /// <summary>
    ///     Displays feedback when a user has logged in.
    /// </summary>
    public sealed class LoggedInView : InformationView
    {
        /// <summary>
        /// Initializes a new instance of the
        ///     <see cref="LoggedInView"/> class.
        /// </summary>
        /// <param name="username">The user name.</param>
        public LoggedInView(string username)
            : base($"You are logged in as {username}")
        {
        }
    }
}
