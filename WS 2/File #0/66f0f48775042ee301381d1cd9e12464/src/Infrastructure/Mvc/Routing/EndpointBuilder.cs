using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;

namespace Infrastructure.Mvc.Routing
{
    public class EndpointBuilder : IEndpointBuilder
    {
        public IDictionary<string, Endpoint> Endpoints { get; }
            = new Dictionary<string, Endpoint>();

        public IDictionary<string, Endpoint> Build(Assembly assembly)
        {
            var controllerTypes = assembly.GetTypes()
                .Where(x => x.GetCustomAttribute<ControllerAttribute>() != null
                    && !x.IsInterface && !x.IsAbstract);

            foreach (var controllerType in controllerTypes)
            {
                var controllerName = GetControllerName(controllerType);
                var methods = GetPublicMethods(controllerType);
                foreach (var method in methods)
                {
                    var parameters = method.GetParameters().Select(x => new ParameterInfo(
                        x.GetCustomAttribute<ParameterAttribute>()?.Name ?? x.Name,
                        x.ParameterType,
                        x.HasDefaultValue,
                        x.DefaultValue))
                        .ToList();
                    var actionName = GetActionName(method);
                    if (controllerName is null && actionName is null)
                    {
                        throw new ApplicationException(
                            $"Invalid RouteAttribute values for '{controllerType.Name}' and '{method.Name}'");
                    }
                    var route = controllerName == null ?
                        actionName : actionName == null ?
                            controllerName : $"{controllerName}-{actionName}";

                    Endpoints.Add(route, new Endpoint(controllerType, method, parameters));
                }
            }
            return Endpoints;
        }

        private static string GetControllerName(MemberInfo controllerType)
        {
            var routeAttr = controllerType.GetCustomAttribute<RouteAttribute>();
            if (routeAttr != null)
            {
                return routeAttr.Value;
            }
            var controllerName = controllerType.Name;
            var length = controllerName.Length - "Controller".Length;
            controllerName = controllerName.Substring(0, length);
            return controllerName.ToLower();
        }

        private static string GetActionName(MemberInfo method)
        {
            var routeAttr = method.GetCustomAttribute<RouteAttribute>();
            return routeAttr != null ? routeAttr.Value : method.Name.ToLower();
        }

        private static IEnumerable<MethodInfo> GetPublicMethods(Type controllerType)
        {
            return controllerType
                .GetMethods()
                .Where(x => x.IsPublic && x.DeclaringType != typeof(object));
        }
    }
}
