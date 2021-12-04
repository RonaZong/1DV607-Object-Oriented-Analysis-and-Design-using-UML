using System.Threading.Tasks;

namespace Core.Domain.Repositories
{
    /// <summary>
    ///     Generic repository interface.
    /// </summary>
    public interface IRepository<T>
    {
        public Task<T> Get(int id);
        public void RegisterNew(T entity);
        public void RegisterUpdated(T entity);
        public void RegisterDeleted(T entity);
    }
}
