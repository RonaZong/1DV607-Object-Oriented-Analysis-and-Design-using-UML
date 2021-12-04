using System;
using System.Threading;
using System.Threading.Tasks;

namespace Core.Application
{
    /// <summary>
    ///     Maintains a list of objects affected by a business transaction and
    ///     coordinates the writing out of changes and the resolution of
    ///     concurrency problems.
    ///
    ///     <see href="https://martinfowler.com/eaaCatalog/unitOfWork.html"/>
    /// </summary>
    public interface IUnitOfWork : IDisposable, IAsyncDisposable
    {
        void RegisterNew<T>(T entity);

        void RegisterUpdated<T>(T entity);

        void RegisterDeleted<T>(T entity);

        /// <summary>
        /// 
        /// </summary>
        /// <param name="cancellationToken">
        ///     The cancellation token.
        /// </param>
        /// <returns>
        ///     A <see cref="Task{IUnitOfWork}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        Task<IUnitOfWork> BeginTransaction(
            CancellationToken cancellationToken = default);

        /// <summary>
        ///     Commits all changes made to the database in the current
        ///     transaction asynchronously.
        /// </summary>
        /// <param name="cancellationToken">
        ///     The cancellation token.
        /// </param>
        /// <returns>
        ///     A <see cref="Task"/> representing the asynchronous operation.
        /// </returns>
        Task Commit(CancellationToken cancellationToken = default);

        /// <summary>
        ///     Discards all changes made to the database in the current
        ///     transaction asynchronously.
        /// </summary>
        /// <param name="cancellationToken">
        ///     The cancellation token.
        /// </param>
        /// <returns>
        ///     A <see cref="Task"/> representing the asynchronous operation.
        /// </returns>
        Task Rollback(CancellationToken cancellationToken = default);
    }
}
