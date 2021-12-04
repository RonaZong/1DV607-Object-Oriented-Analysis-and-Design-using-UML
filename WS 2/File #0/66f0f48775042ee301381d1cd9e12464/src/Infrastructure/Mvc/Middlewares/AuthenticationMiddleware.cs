using System.Reflection;
using System.Threading.Tasks;
using Infrastructure.IO;
using Infrastructure.Mvc.Attributes;
using Infrastructure.Mvc.Routing;

namespace Infrastructure.Mvc.Middlewares
{
    public class AuthenticationMiddleware : Middleware
    {
        public override Task Handle(ConsoleContext context)
        {
            if (!IsSecured(context.Endpoint) || context.Session.User.Identity.IsAuthenticated)
                return Next.Handle(context);
            ColoredConsole.Information("Login required!");
            return Task.CompletedTask;
        }

        private static bool IsSecured(Endpoint endpoint)
        {
            return
                endpoint?.ControllerType.GetCustomAttribute<SecuredAttribute>() != null ||
                endpoint?.Method.GetCustomAttribute<SecuredAttribute>() != null;
        }
    }
}
