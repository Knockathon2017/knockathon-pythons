using KnockAPI.Models;
using KnockAPI.Models.Context;
using Nancy;
using Nancy.ModelBinding;
using System.Linq;

namespace KnockAPI.Modules
{
    public class WorkProvidersModule : NancyModule
    {
        public WorkProvidersModule(IApplicationDbContext ctx)
        {
            Get["/workproviders"] = _ =>
                {
                    var providers = ctx.WorkProviders.ToList();
                    //return providers;
                    return Response.AsJson(providers);
                };

            Get["/workprovider/new"] = _ =>
                {
                    ViewBag.Workers = ctx.Workers.OrderBy(x => x.Name).ToList();
                    return View["new", new WorkProvider()];
                };

            Post["/workprovider/new"] = _ =>
                {
                    var workprovider = this.Bind<WorkProvider>();
                    if (workprovider != null)
                    {
                        ctx.WorkProviders.Add(workprovider);
                        ctx.SaveChanges();
                        return Response.AsRedirect("/workproviders");
                    }
                    return 500;
                };

            Get["/workprovider/update/{id}"] = _ =>
                {
                    var id = (long)_.id;
                    var workprovider = ctx.WorkProviders.Where(x => x.WorkProviderId == id).FirstOrDefault();
                    if (workprovider != null)
                    {
                        return View["update", new WorkProvider() { WorkProviderId = workprovider.WorkProviderId, Name = workprovider.Name }];
                    }
                    return 404;
                };

            Post["/workprovider/update"] = _ =>
                {
                    var workprovider = this.Bind<WorkProvider>();
                    if (workprovider != null)
                    {
                        ctx.SetModified(workprovider);
                        ctx.SaveChanges();
                        return Response.AsRedirect("/workproviders");
                    }
                    return 500;
                };


            Get["/workprovider/delete/{id}"] = _ =>
            {
                var id = (long)_.id;
                if (ctx.WorkProviders.Any(x => x.WorkProviderId == id))
                {
                    ViewBag.WorkProviderId = id;
                    return View["delete"];
                }
                return 404;
            };

            Post["/workprovider/deleteconfirmed"] = _ =>
            {
                WorkProvider workprovider = this.Bind<WorkProvider>();
                if (workprovider != null)
                {
                    var dbWorker = ctx.WorkProviders.Where(x => x.WorkProviderId == workprovider.WorkProviderId).FirstOrDefault();
                    ctx.WorkProviders.Remove(dbWorker);
                    ctx.SaveChanges();
                    return Response.AsRedirect("/workproviders");
                }
                return 500;
            };
        }
    }
}