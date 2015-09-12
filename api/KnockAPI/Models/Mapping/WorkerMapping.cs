using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace KnockAPI.Models.Mapping
{
    public class WorkerMapping : EntityTypeConfiguration<Worker>
    {
        public WorkerMapping()
        {
            ToTable("Workers");

            HasKey(x => x.WorkerId)
                .Property(x => x.WorkerId)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            Property(x => x.IsAvailable)
                .HasColumnType("bit");

            Property(x => x.UserId)
                .IsRequired();

            Property(x => x.CreatedAt)
                .IsRequired();

            Property(x => x.ModifiedAt)
                .IsRequired();

        }
    }
}