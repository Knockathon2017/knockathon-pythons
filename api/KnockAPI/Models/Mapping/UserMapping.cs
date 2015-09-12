using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace KnockAPI.Models.Mapping
{
    public class UserMapping : EntityTypeConfiguration<User>
    {
        public UserMapping()
        {
            ToTable("Users");

            HasKey(x => x.UserId)
                .Property(x => x.UserId)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            Property(x => x.FirstName)
                .HasColumnType("varchar")
                .IsRequired()
                .HasMaxLength(100);

            Property(x => x.LastName)
              .HasColumnType("varchar")
              .IsRequired()
              .HasMaxLength(100);

            Property(x => x.Age)
              .HasColumnType("int")
              .IsRequired();

            Property(x => x.Sex)
              .HasColumnType("varchar")
              .IsRequired().HasMaxLength(10);

            Property(x => x.LocationKey)
               .HasColumnType("varchar")
               .IsRequired()
               .HasMaxLength(100);

            Property(x => x.ContactNo1)
              .HasColumnType("varchar")
              .IsRequired()
              .HasMaxLength(15);

            Property(x => x.ContactNo2)
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