using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace KnockAPI.Models.Mapping
{
    public class WorkTypeMapping : EntityTypeConfiguration<WorkType>
    {
        public WorkTypeMapping()
        {
            ToTable("WorkType");

            HasKey(x => x.WorkTypeId)
                .Property(x => x.WorkTypeId)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            Property(x => x.WorkNature)
               .HasColumnType("varchar")
                .IsRequired()
                .HasMaxLength(150);

            Property(x => x.Category)
              .HasColumnType("varchar")
                .IsRequired()
                .HasMaxLength(100);

            Property(x => x.CreatedAt)
                .IsRequired();

            Property(x => x.ModifiedAt)
                .IsRequired();


        }
    }
}