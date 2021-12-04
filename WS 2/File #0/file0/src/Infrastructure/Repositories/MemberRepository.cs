using System.Collections.Generic;
using System.Threading.Tasks;
using Core.Domain.Entities;
using Core.Domain.Repositories;
using Infrastructure.Data;
using Microsoft.EntityFrameworkCore;

namespace Infrastructure.Repositories
{
    /// <inheritdoc/>
    internal sealed class MemberRepository : Repository<Member>, IMemberRepository
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberRepository"/> class.
        /// </summary>
        /// <param name="context">The context.</param>
        public MemberRepository(YachtClubContext context) : base(context)
        {
        }

        /// <inheritdoc/>
        public async Task<IEnumerable<Member>> List()
        {
            return await Context.Members.Include(x => x.Boats).ToListAsync();
        }
    }
}
