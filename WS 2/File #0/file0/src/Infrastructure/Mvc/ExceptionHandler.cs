using System;
using System.Threading.Tasks;
using Infrastructure.Mvc.Abstractions;

namespace Infrastructure.Mvc
{
    public class ExceptionHandler : IExceptionHandler
    {
        public async Task HandleError(ConsoleContext context, Exception exception)
        {
            await Console.Error.WriteLineAsync(exception.Message);
            await Console.Error.WriteLineAsync(exception.StackTrace ?? @"¯\_(ツ)_/¯");
        }
    }
}
