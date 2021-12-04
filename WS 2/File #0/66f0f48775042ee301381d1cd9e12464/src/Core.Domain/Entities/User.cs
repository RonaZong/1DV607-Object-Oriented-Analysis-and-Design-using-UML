using Core.Domain.VO;

namespace Core.Domain.Entities
{
    /// <summary>
    ///     Represents an application user.
    /// </summary>
    /// TODO: shouldnt be here since it isnt apart of the bounded context.
    ///       same goes with password and 2fa interfaces.
    /// TODO: Make immutable!
    public class User
    {
        /// <summary>
        ///     Gets or sets the user id.
        /// </summary>
        public int Id { get; set; }

        /// <summary>
        ///     Gets or sets the user name.
        /// </summary>
        public string Username { get; set; }

        /// <summary>
        ///     Gets or sets the user password.
        /// </summary>
        public IPassword Password { get; set; }

        /// <summary>
        ///     Gets or sets the 2FA configuration.
        /// </summary>
        public ITwoFactor TwoFactor { get; set; }
    }
}
