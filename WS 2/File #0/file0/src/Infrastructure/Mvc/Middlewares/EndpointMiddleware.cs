using System;
using System.Linq;
using System.Threading.Tasks;
using Infrastructure.Mvc.Abstractions;

namespace Infrastructure.Mvc.Middlewares
{
    public class EndpointMiddleware : Middleware
    {
        private readonly IServiceProvider _serviceProvider;

        public EndpointMiddleware(IServiceProvider serviceProvider)
        {
            _serviceProvider = serviceProvider;
        }

        public override async Task Handle(ConsoleContext context)
        {
            if (context.Endpoint == null)
            {
                await Next.Handle(context);
                return;
            }
            var endpoint = context.Endpoint;
            var request = context.Request;
            object[] methodParams = null;
            if (context.Request.Parameters.Count > 0)
            {
                methodParams = endpoint.Parameters.Select(x =>
                {
                    if (request.Parameters.ContainsKey(x.Name))
                    {
                        return Convert.ChangeType(
                            context.Request.Parameters[x.Name], x.Type);
                    }
                    return x.HasDefaultValue ? x.DefaultValue : null;
                })
                .ToArray();
            }
            var controller = _serviceProvider.GetService(endpoint.ControllerType);
            var result = await (dynamic)endpoint.Method.Invoke(controller, methodParams);
            if (result is IView view)
            {
                view.Render();
                return;
            }
            Console.WriteLine(result);
        }
    }
}
