using System;
using System.Collections.Generic;
using System.Reflection;

namespace Infrastructure.Mvc.Routing
{
    public class Endpoint
    {
        public Endpoint(
            Type controllerType, MethodInfo method, IEnumerable<ParameterInfo> parameters)
        {
            ControllerType = controllerType;
            Method = method;
            Parameters = parameters;
        }
        public Type ControllerType { get; }
        public MethodInfo Method { get; }
        public IEnumerable<ParameterInfo> Parameters { get; }
    }
}
