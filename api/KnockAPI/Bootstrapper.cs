namespace KnockAPI
{
    using KnockAPI.Models.Context;
    using Nancy;
    using Nancy.TinyIoc;

    public class Bootstrapper : DefaultNancyBootstrapper
    {
        protected override void ConfigureRequestContainer(TinyIoCContainer container, NancyContext context)
        {
            container.Register<IApplicationDbContext, ApplicationDbContext>();
        }
    }
}