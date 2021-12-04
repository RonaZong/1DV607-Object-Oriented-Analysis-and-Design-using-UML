using System.Threading.Tasks;
using Infrastructure.Mvc.Routing;

namespace Infrastructure.Mvc.Middlewares
{
    public class RouteMiddleware : Middleware
    {
        public override Task Handle(ConsoleContext context)
        {
            context.Endpoints.TryGetValue(
                context.Request.Operation, out var endpoint);
            if (endpoint != null)
            {
                context.Endpoint = endpoint;
            }
            return Next.Handle(context);
        }
    }
}
