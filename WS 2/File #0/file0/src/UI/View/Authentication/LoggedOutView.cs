using UI.View.Shared;

namespace UI.View.Authentication
{
    /// <summary>
    ///     Displays feedback when a user has logged out.
    /// </summary>
    public class LoggedOutView : InformationView
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="LoggedOutView"/> class.
        /// </summary>
        public LoggedOutView() : base("You are now logged out!")
        {
        }
    }
}
