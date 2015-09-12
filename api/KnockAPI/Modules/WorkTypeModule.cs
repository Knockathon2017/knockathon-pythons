using KnockAPI.Models;
using KnockAPI.Models.Context;
using Nancy;
using Nancy.ModelBinding;
using System.Linq;

namespace KnockAPI.Modules
{
    public class WorkTypeModule : NancyModule
    {
        public WorkTypeModule(IApplicationDbContext ctx)
        {
            Get["/worktype"] = _ =>
                {
                    var worktype = ctx.WorkType.ToList();
                    return View["index", worktype];
                };

            Get["/worktype/new"] = _ =>
                {
                    var worktype = new WorkType();
                    return View["new", worktype];
                };

            Post["/worktype/new"] = parameters =>
                {
                    var worktype = this.Bind<WorkType>();
                    if (worktype != null)
                    {
                        ctx.WorkType.Add(worktype);
                        ctx.SaveChanges();
                        return Response.AsRedirect("/worktype");
                    }
                    return 500;                   
                };

            Get["/worktype/update/{id}"] = _ =>
                {
                    var id = (long)_.id;
                    var worktype = ctx.WorkType.Where(x => x.Id == id).FirstOrDefault();
                    if(worktype != null)
                    {
                        return View["update", new WorkType() { WorkNature = worktype.WorkNature, Id = worktype.Id}];
                    }
                    return 404;
                };

            Post["/worktype/update"] = parameters =>
                {
                    WorkType worktype = this.Bind<WorkType>();
                    if(worktype != null)
                    {
                        ctx.SetModified(worktype);
                        ctx.SaveChanges();
                        return Response.AsRedirect("/worktype");
                    }
                    return 404;
                };
            Get["/worktype/delete/{id}"] = _ =>
                {
                    var id = (long)_.id;
                    if (ctx.WorkType.Any(x => x.Id == id))
                    {
                        ViewBag.WorkerId = id;
                        return View["delete"];
                    }
                    return 404;
                };

            Post["/worktype/deleteconfirmed"] = _ =>
            {
                WorkType worktype = this.Bind<WorkType>();
                if (worktype != null)
                {
                    var dbWorker = ctx.WorkType.Where(x => x.Id == worktype.Id).FirstOrDefault();
                    ctx.WorkType.Remove(dbWorker);
                    ctx.SaveChanges();
                    return Response.AsRedirect("/worktype");
                }
                return 404;
            };
        }
    }
}