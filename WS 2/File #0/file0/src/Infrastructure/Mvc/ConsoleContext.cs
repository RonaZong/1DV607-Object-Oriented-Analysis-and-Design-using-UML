using System.Collections.Generic;
using Infrastructure.Mvc.Routing;
using Infrastructure.Session.Abstractions;

namespace Infrastructure.Mvc
{
    public class ConsoleContext
    {
        public ConsoleContext(ISession session, ConsoleRequest request)
        {
            Session = session;
            Request = request;
        }

        public ISession Session { get; }
        public ConsoleRequest Request { get; }
        public IDictionary<string, Endpoint> Endpoints { get; internal set; }
        public Endpoint Endpoint { get; internal set; }
    }
}
