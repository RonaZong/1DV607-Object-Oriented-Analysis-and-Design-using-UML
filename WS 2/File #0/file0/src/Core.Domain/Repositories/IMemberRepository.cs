using System.Collections.Generic;
using System.Threading.Tasks;
using Core.Domain.Entities;

namespace Core.Domain.Repositories
{
    public interface IMemberRepository : IRepository<Member>
    {
        public Task<IEnumerable<Member>> List();
    }
}
