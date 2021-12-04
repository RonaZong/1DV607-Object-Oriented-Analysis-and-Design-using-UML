using System;
using System.Threading.Tasks;

namespace Infrastructure.Mvc.Abstractions
{
    public interface IExceptionHandler
    {
        Task HandleError(ConsoleContext context, Exception exception);
    }
}
