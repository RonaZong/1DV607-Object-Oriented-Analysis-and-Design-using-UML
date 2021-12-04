using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Infrastructure.Mvc.Routing;

namespace Infrastructure.Mvc.Abstractions
{
    public interface IApplicationBuilder
    {
        IServiceProvider ServiceProvider { get; }

        IDictionary<string, Endpoint> Endpoints { get; }

        /// <summary>
        ///     Builds the delegate used by this application to process console
        ///     commands.
        /// </summary>
        Func<ConsoleContext, Task> Build();

        void UseMiddleware<T>() where T : IMiddleware;

        void UseEndpoints();
    }
}
