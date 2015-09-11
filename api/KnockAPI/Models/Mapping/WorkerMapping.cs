using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace KnockAPI.Models.Mapping
{
    public class WorkerMapping : EntityTypeConfiguration<Worker>
    {
        public WorkerMapping()
        {
            ToTable("Workers");

            HasKey(x => x.Id)
                .Property(x => x.Id)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            Property(x => x.Name)
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