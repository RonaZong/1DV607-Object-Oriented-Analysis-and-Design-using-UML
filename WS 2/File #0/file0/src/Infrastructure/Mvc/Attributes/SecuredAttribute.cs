using System;

namespace Infrastructure.Mvc.Attributes
{
    [AttributeUsage(AttributeTargets.Class | AttributeTargets.Method)]
    public class SecuredAttribute : Attribute
    {
    }
}
