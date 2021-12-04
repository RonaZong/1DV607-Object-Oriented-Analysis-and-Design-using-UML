using System.Collections.Generic;
using System.Reflection;
using Infrastructure.Mvc.Routing;

namespace Infrastructure.Mvc.Abstractions
{
    public interface IEndpointBuilder
    {
        public IDictionary<string, Endpoint> Endpoints { get; }
        public IDictionary<string, Endpoint> Build(Assembly assembly);
    }
}
