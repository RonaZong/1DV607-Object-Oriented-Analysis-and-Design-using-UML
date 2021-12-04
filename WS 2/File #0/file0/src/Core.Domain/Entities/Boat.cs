using Core.Domain.VO;

namespace Core.Domain.Entities
{
    /// <summary>
    ///     Represents a boat.
    /// </summary>
    /// TODO: Make immutable!
    public class Boat
    {
        /// <summary>
        ///     Initializes a new instance of the <see cref="Boat"/> class.
        /// </summary>
        public Boat()
        {
        }

        /// <summary>
        ///     Initializes a new instance of the <see cref="Boat"/> class.
        /// </summary>
        /// <param name="type">The boat type.</param>
        /// <param name="length">The length of the boat.</param>
        /// <param name="owner">The owner of the boat.</param>
        public Boat(BoatType type, int length, Member owner)
        {
            Type = type;
            Length = length;
            Owner = owner;
        }

        /// <summary>
        ///     Gets or sets the boat id.
        /// </summary>
        public int Id { get; set; }

        /// <summary>
        ///     Gets or sets the boat type.
        /// </summary>
        public BoatType Type { get; set; }

        /// <summary>
        ///     Gets or sets the boat length.
        /// </summary>
        public int Length { get; set; }

        /// <summary>
        ///     Gets or sets the owner of the boat.
        /// </summary>
        public Member Owner { get; set; }
    }
}
