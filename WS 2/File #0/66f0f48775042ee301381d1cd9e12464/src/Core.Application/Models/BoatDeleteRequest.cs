namespace Core.Application.Models
{
    /// <summary>
    ///     Deletes a boat by id.
    /// </summary>
    public class BoatDeleteRequest
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="BoatDeleteRequest"/> class.
        /// </summary>
        /// <param name="boatId">The boat id.</param>
        public BoatDeleteRequest(int boatId)
        {
            BoatId = boatId;
        }

        /// <summary>
        ///     The boat id.
        /// </summary>
        public int BoatId { get; }
    }
}
