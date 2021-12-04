using System.Collections.Generic;

namespace Core.Domain.Entities
{
    /// <summary>
    ///     Represents a yacht club member.
    /// </summary>
    /// TODO: Make immutable!
    public class Member
    {
        /// <summary>
        ///     Gets or sets the member id.
        /// </summary>
        public int Id { get; set; }

        /// <summary>
        ///     Gets or sets the name.
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        ///     Gets or sets the personal identity number.
        /// </summary>
        public string PersonalIdentityNumber { get; set; }

        /// <summary>
        ///     Gets or sets the owned boats.
        /// </summary>
        public IEnumerable<Boat> Boats { get; set; }
    }
}
