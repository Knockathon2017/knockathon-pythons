using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace KnockAPI.Models.Mapping
{
    public class WorkProviderMapping : EntityTypeConfiguration<WorkProvider>
    {
        public WorkProviderMapping()
        {
            ToTable("WorkProviders");

            HasKey(x => x.WorkProviderId)
                .Property(x => x.WorkProviderId)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);


            Property(x => x.UserId)
               .IsRequired();

            Property(x => x.RequiredWorkforce)
               .HasColumnType("int");

            Property(x => x.CreatedAt)
                .IsRequired();

            Property(x => x.ModifiedAt)
                .IsRequired();

            
        }
    }
}