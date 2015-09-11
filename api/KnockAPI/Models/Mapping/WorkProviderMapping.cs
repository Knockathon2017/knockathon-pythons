using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace KnockAPI.Models.Mapping
{
    public class WorkProviderMapping : EntityTypeConfiguration<WorkProvider>
    {
        public WorkProviderMapping()
        {
            ToTable("WorkProviders");

            HasKey(x => x.Id)
                .Property(x => x.Id)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            Property(x => x.Name)
                .IsRequired()
                .HasColumnType("varchar")
                .HasMaxLength(100);

            Property(x => x.CreatedAt)
                .IsRequired();

            Property(x => x.ModifiedAt)
                .IsRequired();

            
        }
    }
}