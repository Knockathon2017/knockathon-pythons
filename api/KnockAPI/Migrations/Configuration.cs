namespace KnockAPI.Migrations
{
    using KnockAPI.Models;
    using System.Data.Entity.Migrations;

    internal sealed class Configuration : DbMigrationsConfiguration<KnockAPI.Models.Context.ApplicationDbContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(KnockAPI.Models.Context.ApplicationDbContext context)
        {
            //context.Workers.AddOrUpdate(
            //  p => p.Name,
            //  new Worker { Name = "Cha" }
            //);

        }
    }
}
