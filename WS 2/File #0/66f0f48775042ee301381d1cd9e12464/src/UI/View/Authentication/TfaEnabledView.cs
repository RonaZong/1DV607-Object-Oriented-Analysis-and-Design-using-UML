using UI.View.Shared;

namespace UI.View.Authentication
{
    /// <summary>
    ///     Displays feedback when a user successfully has enabled 2FA.
    /// </summary>
    public sealed class TfaEnabledView : InformationView
    {
        /// <summary>
        /// Initializes a new instance of the
        ///     <see cref="TfaEnabledView"/> class.
        /// </summary>
        public TfaEnabledView() : base("You are good to go!")
        {
        }
    }
}
