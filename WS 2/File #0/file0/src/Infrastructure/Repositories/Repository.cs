using System.Threading.Tasks;
using Core.Domain.Repositories;
using Infrastructure.Data;

namespace Infrastructure.Repositories
{
    /// <summary>
    ///     A base repository.
    /// </summary>
    /// <typeparam name="T">The entity type.</typeparam>
    internal class Repository<T> : IRepository<T> where T : class
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="Repository"/> class.
        /// </summary>
        /// <param name="context">The context.</param>
        public Repository(YachtClubContext context)
        {
            Context = context;
        }

        /// <summary>
        ///     Gets the db context.
        /// </summary>
        protected YachtClubContext Context { get; }

        /// <inheritdoc/>
        public async Task<T> Get(int id)
        {
            return await Context.FindAsync<T>(id);
        }

        /// <inheritdoc/>
        public void RegisterDeleted(T entity)
        {
            Context.Remove(entity);
        }

        /// <inheritdoc/>
        public void RegisterNew(T entity)
        {
            Context.Add(entity);
        }

        /// <inheritdoc/>
        public void RegisterUpdated(T entity)
        {
            Context.Update(entity);
        }
    }
}
