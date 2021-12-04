using Core.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infrastructure.Data.EntityConfigurations
{
    /// <inheritdoc/>
    internal class MemberEntityTypeConfiguration : IEntityTypeConfiguration<Member>
    {
        /// <iheritdoc/>
        public void Configure(EntityTypeBuilder<Member> builder)
        {
            builder.ToTable("Members", "dbo");
            builder.HasKey(member => member.Id);
            builder.Property(member => member.Name);
            builder.Property(member => member.PersonalIdentityNumber);
            // TODO: We can safely ignore a unique index to minimize errors.
            builder.HasIndex(member => member.PersonalIdentityNumber).IsUnique();
            builder.HasMany<Boat>();
        }
    }
}
