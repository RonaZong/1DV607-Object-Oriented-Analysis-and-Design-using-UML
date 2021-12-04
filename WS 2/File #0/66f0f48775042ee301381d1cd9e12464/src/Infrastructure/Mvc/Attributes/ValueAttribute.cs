using System;

namespace Infrastructure.Mvc.Attributes
{
    public abstract class ValueAttribute : Attribute
    {
        protected ValueAttribute(string value)
        {
            Value = value;
        }

        public string Value { get; }
    }
}
