using Core.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infrastructure.Data.EntityConfigurations
{
    /// <inheritdoc/>
    internal class BoatEntityTypeConfiguration : IEntityTypeConfiguration<Boat>
    {
        /// <inheritdoc/>
        public void Configure(EntityTypeBuilder<Boat> builder)
        {
            builder.ToTable("Boats", "dbo");
            builder.HasKey(boat => boat.Id);
            builder.Property(boat => boat.Type);
            builder.Property(boat => boat.Length);
            builder.HasOne<Member>(boat => boat.Owner);
        }
    }
}
