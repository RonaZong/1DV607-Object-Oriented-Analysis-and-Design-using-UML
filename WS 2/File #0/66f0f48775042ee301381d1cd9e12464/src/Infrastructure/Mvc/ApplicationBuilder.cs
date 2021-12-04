using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Middlewares;
using Infrastructure.Mvc.Routing;

namespace Infrastructure.Mvc
{
    public class ApplicationBuilder : IApplicationBuilder
    {
        public IServiceProvider ServiceProvider { get; }

        private readonly List<IMiddleware> _middlewares
            = new List<IMiddleware>();

        public IDictionary<string, Endpoint> Endpoints { get; private set; }
            = new Dictionary<string, Endpoint>();

        public ApplicationBuilder(IServiceProvider serviceProvider)
        {
            ServiceProvider = serviceProvider;
        }

        public Func<ConsoleContext, Task> Build()
        {
            IMiddleware chain = new EndMiddleware();
            foreach (var middleware in _middlewares.Reverse<IMiddleware>())
            {
                middleware.Register(chain);
                chain = middleware;
            }
            return async request =>
            {
                request.Endpoints = Endpoints;
                await chain.Handle(request);
            };
        }

        public void UseMiddleware<T>() where T : IMiddleware
        {
            var ctor = typeof(T).GetConstructors().First();
            var parameters = new List<object>();
            foreach (var ctorParameter in ctor.GetParameters().OrderBy(param => param.Position))
            {
                var arg = ServiceProvider.GetService(ctorParameter.ParameterType);
                if (arg == null)
                {
                    throw new Exception(
                        $"Missing injected argument: {ctorParameter.Name} for type: {ctorParameter.ParameterType}");
                }
                parameters.Add(arg);
            }
            var middleware = ctor.Invoke(parameters.ToArray()) as IMiddleware;
            _middlewares.Add(middleware);
        }

        public void UseEndpoints()
        {
            var builder = new EndpointBuilder();
            Endpoints = builder.Build(Assembly.GetCallingAssembly());
        }
    }
}
