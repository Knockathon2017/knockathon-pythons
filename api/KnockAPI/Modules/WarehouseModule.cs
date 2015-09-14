using KnockAPI.Models;
using KnockAPI.Models.Context;
using Nancy;
using Nancy.ModelBinding;
using System.Linq;

namespace KnockAPI.Modules
{
    public class WarehouseModule : NancyModule
    {
        public WarehouseModule(IApplicationDbContext ctx)
        {
            Get["/warehouse"] = _ =>
            {
                var warehouses = ctx.Warehouses.ToList();
                return warehouses;
            };

            Get["/warehouse/new"] = _ =>
            {
                var warehouse = new Warehouse();
                return View["new", warehouse];
            };

            Post["/warehouse/new"] = parameters =>
            {
                var warehouse = this.Bind<Warehouse>();
                if (warehouse != null)
                {
                    ctx.Warehouses.Add(warehouse);
                    ctx.SaveChanges();
                    return Response.AsRedirect("/warehouse");
                }
                return 500;
            };

            Get["/warehouse/update/{id}"] = _ =>
            {
                var id = (long)_.id;
                var warehouse = ctx.Warehouses.Where(x => x.WarehouseId == id).FirstOrDefault();
                if (warehouse != null)
                {
                    return View["update", warehouse];
                }
                return 404;
            };

            Post["/warehouse/update"] = parameters =>
            {
                Warehouse warehouse = this.Bind<Warehouse>();
                if (warehouse != null)
                {
                    ctx.SetModified(warehouse);
                    ctx.SaveChanges();
                    return Response.AsRedirect("/warehouse");
                }
                return 404;
            };
            Get["/warehouse/delete/{id}"] = _ =>
            {
                var id = (long)_.id;
                if (ctx.Warehouses.Any(x => x.WarehouseId == id))
                {
                    ViewBag.WarehouseId = id;
                    return View["delete"];
                }
                return 404;
            };

            Post["/warehouse/deleteconfirmed"] = _ =>
            {
                Warehouse warehouse = this.Bind<Warehouse>();
                if (warehouse != null)
                {
                    var dbWarehouse = ctx.Warehouses.Where(x => x.WarehouseId == warehouse.WarehouseId).FirstOrDefault();
                    ctx.Warehouses.Remove(dbWarehouse);
                    ctx.SaveChanges();
                    return Response.AsRedirect("/warehouse");
                }
                return 404;
            };
        }
    }
}