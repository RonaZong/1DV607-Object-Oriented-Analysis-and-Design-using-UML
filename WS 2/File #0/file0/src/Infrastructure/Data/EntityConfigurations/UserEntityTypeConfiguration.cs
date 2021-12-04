using Core.Domain.Entities;
using Infrastructure.Data.VO;
using Microsoft.AspNetCore.DataProtection;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infrastructure.Data.EntityConfigurations
{
    /// <inheritdoc/>
    internal class UserEntityTypeConfiguration : IEntityTypeConfiguration<User>
    {
        /// <summary>
        ///     The data protector.
        /// </summary>
        private readonly IDataProtector _dataProtector;

        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="UserEntityTypeConfiguration"/> class.
        /// </summary>
        /// <param name="dataProtector">The data protector.</param>
        public UserEntityTypeConfiguration(IDataProtector dataProtector)
        {
            _dataProtector = dataProtector;
        }

        /// <inheritdoc/>
        public void Configure(EntityTypeBuilder<User> builder)
        {
            builder.ToTable("Users", "dbo");
            builder.HasKey(user => user.Id);
            builder.Property(user => user.Username);
            builder.Property(user => user.Password).HasConversion(
                password => _dataProtector.Protect(password.Value),
                hash => PasswordHash.With(_dataProtector.Unprotect(hash)));
            builder.Property(user => user.TwoFactor).HasConversion(
                    value =>
                        _dataProtector.Protect(value.Secret),
                    value =>
                        new TwoFactor(_dataProtector.Unprotect(value)));
            builder.HasIndex(user => user.Username).IsUnique();
        }
    }
}
