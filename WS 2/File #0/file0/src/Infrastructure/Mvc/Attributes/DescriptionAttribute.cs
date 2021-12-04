using System;

namespace Infrastructure.Mvc.Attributes
{
    [AttributeUsage(AttributeTargets.Method | AttributeTargets.Parameter)]
    public class DescriptionAttribute : ValueAttribute
    {
        public DescriptionAttribute(string description) : base(description)
        {
        }
    }
}
