namespace UI.Models
{
    /// <summary>
    ///     The member view model.
    /// </summary>
    public sealed class MemberViewModel
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberViewModel"/> class.
        /// </summary>
        /// <param name="id">The member id.</param>
        /// <param name="name">The member name.</param>
        /// <param name="personalIdentityNumber">
        ///     The member personal identity number.
        /// </param>
        /// <param name="boatCount">
        ///     The amount of boats owned by this member.
        /// </param>
        public MemberViewModel(
            int id,
            string name,
            string personalIdentityNumber,
            int boatCount)
        {
            Id = id;
            Name = name;
            PersonalIdentityNumber = personalIdentityNumber;
            BoatCount = boatCount;
        }

        /// <summary>
        ///     Gets the member id.
        /// </summary>
        public int Id { get; }

        /// <summary>
        ///     Gets the member name.
        /// </summary>
        public string Name { get; }

        /// <summary>
        ///     Gets the member personal identity number.
        /// </summary>
        public string PersonalIdentityNumber { get; }

        /// <summary>
        ///     Gets the boat count for this member.
        /// </summary>
        public int BoatCount { get; }
    }
}
