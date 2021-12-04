using System.Threading;
using System.Threading.Tasks;
using System.Transactions;
using Core.Application;
using Core.Domain.Entities;
using Infrastructure.Data.EntityConfigurations;
using Microsoft.AspNetCore.DataProtection;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage;

namespace Infrastructure.Data
{
    // TODO: Split contexts - applicationuser vs domain.
    public class YachtClubContext : DbContext, IUnitOfWork
    {
        /// <summary>
        ///     The data protector.
        /// </summary>
        private readonly IDataProtector _dataProtector;

        /// <summary>
        ///     The 
        /// </summary>
        private IDbContextTransaction _transaction;

        /// <summary>
        ///     Initializes a new instance of the <see cref="YachtClubContext"/>
        ///     class.
        /// </summary>
        /// <param name="options">The context options.</param>
        /// <param name="dataProtectionProvider">
        ///     The data protection provider.
        /// </param>
        public YachtClubContext(
            DbContextOptions<YachtClubContext> options,
            IDataProtectionProvider dataProtectionProvider)
            : base(options)
        {
            _dataProtector = dataProtectionProvider.CreateProtector(
                nameof(UserEntityTypeConfiguration));
        }

        /// <summary>
        ///     Gets or set the members database set.
        /// </summary>
        public DbSet<Member> Members { get; set; }

        /// <summary>
        ///     Gets or set the users database set.
        /// </summary>
        public DbSet<User> Users { get; set; }

        /// <summary>
        ///     Gets or set the boats database set.
        /// </summary>
        public DbSet<Boat> Boats { get; set; }

        /// <inheritdoc/>
        public async Task<IUnitOfWork> BeginTransaction(
            CancellationToken cancellationToken = default)
        {
            _transaction ??= await Database
                .BeginTransactionAsync(cancellationToken);
            return this;
        }

        /// <inheritdoc/>
        public async Task Commit(CancellationToken cancellationToken = default)
        {
            if (_transaction == null)
            {
                throw new TransactionException("No transaction started");
            }
            try
            {
                await SaveChangesAsync(cancellationToken);
                await _transaction.CommitAsync(cancellationToken);
            }
            catch
            {
                await Rollback(cancellationToken);
                throw;
            }
            finally
            {
                DisposeTransaction();
            }
        }

        /// <inheritdoc/>
        public async Task Rollback(CancellationToken cancellationToken = default)
        {
            try
            {
                await _transaction?.RollbackAsync(cancellationToken);
            }
            finally
            {
                DisposeTransaction();
            }
        }

        /// <inheritdoc/>
        public void RegisterNew<T>(T entity)
        {
            Add(entity);
        }

        /// <inheritdoc/>
        public void RegisterUpdated<T>(T entity)
        {
            Update(entity);
        }

        /// <inheritdoc/>
        public void RegisterDeleted<T>(T entity)
        {
            Remove(entity);
        }

        /// <inheritdoc/>
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.ApplyConfiguration(new MemberEntityTypeConfiguration());
            modelBuilder.ApplyConfiguration(new BoatEntityTypeConfiguration());
            modelBuilder.ApplyConfiguration(
                new UserEntityTypeConfiguration(_dataProtector));
        }

        /// <summary>
        ///     Disposes the transaction.
        /// </summary>
        private void DisposeTransaction()
        {
            if (_transaction == null)
            {
                return;
            }
            _transaction.Dispose();
            _transaction = null;
        }
    }
}
