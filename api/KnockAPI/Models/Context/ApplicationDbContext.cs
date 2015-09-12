using KnockAPI.Models.Mapping;
using System;
using System.Data.Entity;
using System.Linq;

namespace KnockAPI.Models.Context
{
    public class ApplicationDbContext : DbContext, IApplicationDbContext
    {
        public ApplicationDbContext()
            : base("ApplicationDbContext")
        { }

        public IDbSet<WorkProvider> WorkProviders { get; set; }
        public IDbSet<Worker> Workers { get; set; }
        public IDbSet<User> Users { get; set; }
        public IDbSet<WorkType> WorkType { get; set; }
        public IDbSet<Warehouse> Warehouses { get; set; }
        public void SetModified(object entity)
        {
            Entry(entity).State = EntityState.Modified;
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Configurations.Add(new WorkProviderMapping());
            modelBuilder.Configurations.Add(new WorkerMapping());
            modelBuilder.Configurations.Add(new UserMapping());
            modelBuilder.Configurations.Add(new WorkTypeMapping());
            modelBuilder.Configurations.Add(new WarehouseMapping());
        }

        public override int SaveChanges()
        {
            #region -- Created at --
            foreach (var entry in ChangeTracker.Entries().Where(entry => entry.Entity.GetType().GetProperty("CreatedAt") != null))
            {
                if (entry.State == EntityState.Added)
                {
                    entry.Property("CreatedAt").CurrentValue = DateTime.Now;
                }

                if (entry.State == EntityState.Modified)
                {
                    entry.Property("CreatedAt").IsModified = false;
                }
            }
            #endregion

            #region -- Modified at --
            foreach (var entry in ChangeTracker.Entries().Where(entry => entry.Entity.GetType().GetProperty("ModifiedAt") != null))
            {
                if (entry.State == EntityState.Modified || entry.State == EntityState.Added)
                {
                    entry.Property("ModifiedAt").CurrentValue = DateTime.Now;
                }
            }
            #endregion

            return base.SaveChanges();
        }
    }
}