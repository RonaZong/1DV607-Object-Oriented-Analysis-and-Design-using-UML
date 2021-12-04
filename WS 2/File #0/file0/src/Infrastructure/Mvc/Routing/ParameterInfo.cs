using System;

namespace Infrastructure.Mvc.Routing
{
    public class ParameterInfo
    {
        public ParameterInfo(string name, Type type, bool hasDefaultValue, object defaultValue)
        {
            Name = name;
            Type = type;
            HasDefaultValue = hasDefaultValue;
            DefaultValue = defaultValue;
        }
        public string Name { get; }
        public Type Type { get; }
        public bool HasDefaultValue { get; }
        public object DefaultValue { get; }
    }
}
