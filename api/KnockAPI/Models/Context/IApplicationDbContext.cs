using System.Data.Entity;

namespace KnockAPI.Models.Context
{
    public interface IApplicationDbContext
    {
        IDbSet<WorkProvider> WorkProviders { get; set; }
        IDbSet<Worker> Workers { get; set; }
        IDbSet<User> Users { get; set; }
        IDbSet<WorkType> WorkType { get; set; }
        IDbSet<Warehouse> Warehouses { get; set; }
        int SaveChanges();

        void SetModified(object entity);
    }
}
