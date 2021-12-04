using System;

namespace Infrastructure.Mvc.Attributes
{
    [AttributeUsage(AttributeTargets.Class | AttributeTargets.Method)]
    public class RouteAttribute : ValueAttribute
    {
        public RouteAttribute() : base(null)
        {
        }

        public RouteAttribute(string name) : base(name)
        {
        }
    }
}
