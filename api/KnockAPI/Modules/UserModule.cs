using KnockAPI.Models;
using KnockAPI.Models.Context;
using Nancy;
using Nancy.ModelBinding;
using System.Linq;

namespace KnockAPI.Modules
{
    public class UsersModule : NancyModule
    {
        public UsersModule(IApplicationDbContext ctx)
        {
            Get["/users"] = _ =>
                {
                    var users = ctx.Users.ToList();
                    return View["index", users];
                };

            Get["/user/new"] = _ =>
                {
                    var user = new User();
                    return View["new", user];
                };

            Post["/user/new"] = parameters =>
                {
                    var user = this.Bind<User>();
                    if (user != null)
                    {
                        ctx.Users.Add(user);
                        ctx.SaveChanges();
                      //  return Response.AsRedirect("/users");
                        return 200;
                    }
                    return 500;
                };

            Get["/user/update/{id}"] = _ =>
                {
                    var id = (long)_.id;
                    var user = ctx.Users.Where(x => x.UserId == id).FirstOrDefault();
                    if (user != null)
                    {
                        return View["update", new User() { Name = user.FirstName, UserId = user.UserId }];
                    }
                    return 404;
                };

            Post["/user/update"] = parameters =>
                {
                    User user = this.Bind<User>();
                    if (user != null)
                    {
                        ctx.SetModified(user);
                        ctx.SaveChanges();
                        //return Response.AsRedirect("/users");
                        return 200;
                    }
                    return 404;
                };
            Get["/user/delete/{id}"] = _ =>
                {
                    var id = (long)_.id;
                    if (ctx.Users.Any(x => x.UserId == id))
                    {
                        ViewBag.WorkerId = id;
                        return View["delete"];
                    }
                    return 404;
                };

            Post["/user/deleteconfirmed"] = _ =>
            {
                User user = this.Bind<User>();
                if (user != null)
                {
                    var dbWorker = ctx.Users.Where(x => x.UserId == user.UserId).FirstOrDefault();
                    ctx.Users.Remove(dbWorker);
                    ctx.SaveChanges();
                   // return Response.AsRedirect("/users");
                    return 200;
                }
                return 404;
            };
        }
    }
}