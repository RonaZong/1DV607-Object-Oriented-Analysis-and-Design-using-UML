using System;

namespace Infrastructure.Mvc.Attributes
{
    [AttributeUsage(AttributeTargets.Parameter)]
    public class ParameterAttribute : Attribute
    {
        public ParameterAttribute(string name)
        {
            Name = name;
        }
        public string Name { get; }
        public string Description { get; set; }
    }
}
