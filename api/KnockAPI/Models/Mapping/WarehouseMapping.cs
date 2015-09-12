using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace KnockAPI.Models.Mapping
{
    public class WarehouseMapping : EntityTypeConfiguration<Warehouse>
    {
        public WarehouseMapping()
        {
            ToTable("Warehouse");

            HasKey(x => x.WarehouseId)
                .Property(x => x.WarehouseId)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            Property(x => x.UserId)
               .IsRequired();

            Property(x => x.Capacity)
               .HasColumnType("varchar")
              .IsRequired()
              .HasMaxLength(15);

            Property(x => x.Occupied)
              .HasColumnType("varchar")
              .IsRequired()
              .HasMaxLength(15);

            Property(x => x.Free)
              .HasColumnType("varchar")
              .IsRequired()
              .HasMaxLength(15);

            Property(x => x.CreatedAt)
                .IsRequired();

            Property(x => x.ModifiedAt)
                .IsRequired();


        }
    }
}