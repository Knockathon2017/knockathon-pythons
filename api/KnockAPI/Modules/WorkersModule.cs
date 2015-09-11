using KnockAPI.Models;
using KnockAPI.Models.Context;
using Nancy;
using Nancy.ModelBinding;
using System.Linq;

namespace KnockAPI.Modules
{
    public class WorkersModule : NancyModule
    {
        public WorkersModule(IApplicationDbContext ctx)
        {
            Get["/workers"] = _ =>
                {
                    var workers = ctx.Workers.ToList();
                    return View["index", workers];
                };

            Get["/worker/new"] = _ =>
                {
                    var worker = new Worker();
                    return View["new", worker];
                };

            Post["/worker/new"] = parameters =>
                {
                    var worker = this.Bind<Worker>();
                    if (worker != null)
                    {
                        ctx.Workers.Add(worker);
                        ctx.SaveChanges();
                        return Response.AsRedirect("/workers");
                    }
                    return 500;                   
                };

            Get["/worker/update/{id:long}"] = _ =>
                {
                    var id = (long)_.id;
                    var worker = ctx.Workers.Where(x => x.Id == id).FirstOrDefault();
                    if(worker != null)
                    {
                        return View["update", new Worker() { Name = worker.Name, Id = worker.Id}];
                    }
                    return 404;
                };

            Post["/worker/update"] = parameters =>
                {
                    Worker worker = this.Bind<Worker>();
                    if(worker != null)
                    {
                        ctx.SetModified(worker);
                        ctx.SaveChanges();
                        return Response.AsRedirect("/workers");
                    }
                    return 404;
                };
            Get["/worker/delete/{id:long}"] = _ =>
                {
                    var id = (long)_.id;
                    if (ctx.Workers.Any(x => x.Id == id))
                    {
                        ViewBag.WorkerId = id;
                        return View["delete"];
                    }
                    return 404;
                };

            Post["/worker/deleteconfirmed"] = _ =>
            {
                Worker worker = this.Bind<Worker>();
                if (worker != null)
                {
                    var dbWorker = ctx.Workers.Where(x => x.Id == worker.Id).FirstOrDefault();
                    ctx.Workers.Remove(dbWorker);
                    ctx.SaveChanges();
                    return Response.AsRedirect("/workers");
                }
                return 404;
            };
        }
    }
}