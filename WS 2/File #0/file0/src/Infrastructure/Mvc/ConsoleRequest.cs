using System;
using System.Collections.Generic;
using System.Linq;

namespace Infrastructure.Mvc
{
    public class ConsoleRequest
    {
        private ConsoleRequest(
            string operation, IReadOnlyDictionary<string, object> parameters)
        {
            Operation = operation;
            Parameters = parameters;
        }

        public string Operation { get; }
        public IReadOnlyDictionary<string, object> Parameters { get; }

        public static ConsoleRequest Parse(string input)
        {
            if (string.IsNullOrWhiteSpace(input))
            {
                throw new ArgumentException(
                    $"{nameof(input)} is null, empty or consist only of white space characters");
            }
            var args = input.Split(" ");
            var operation = args.First();

            // TODO: This will start hating if args are -fn firstname lastname
            if ((args.Length - 1) % 2 != 0)
            {
                throw new ArgumentException(
                    $"{nameof(input)} must have equal set of arguments");
            }
            // TODO: Same as above.
            var parameters = new Dictionary<string, object>();
            for (var i = 1; i < args.Length - 1; i += 2)
            {
                var argument = args[i];
                if (! argument.StartsWith("-"))
                {
                    throw new ArgumentException($"{argument} must start with a '-'");
                }
                parameters.Add(args[i].Substring(1), args[i + 1]);
            }
            return new ConsoleRequest(operation, parameters);
        }
    }
}
