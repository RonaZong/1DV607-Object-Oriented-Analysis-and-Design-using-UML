using Core.Domain.Entities;
using Core.Domain.Repositories;
using Infrastructure.Data;

namespace Infrastructure.Repositories
{
    /// <inheritdoc/>
    internal sealed class BoatRepository : Repository<Boat>, IBoatRepository
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="BoatRepository"/> class.
        /// </summary>
        /// <param name="context">The context.</param>
        public BoatRepository(YachtClubContext context) : base(context)
        {
        }
    }
}
