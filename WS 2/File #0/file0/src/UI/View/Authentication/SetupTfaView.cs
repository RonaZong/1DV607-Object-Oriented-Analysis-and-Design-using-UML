using UI.View.Shared;

namespace UI.View.Authentication
{
    /// <summary>
    ///     Displays feedback when a user setup 2FA.
    /// </summary>
    public sealed class SetupTfaView : InformationView
    {
        /// <summary>
        /// Initializes a new instance of the
        ///     <see cref="SetupTfaView"/> class.
        /// </summary>
        /// <param name="username">The user name.</param>
        public SetupTfaView(string link)
            : base($"Paste the following link in your chrome browser:\n {link}. \nRemember to enable 2FA with a verification code")
        {
        }
    }
}
