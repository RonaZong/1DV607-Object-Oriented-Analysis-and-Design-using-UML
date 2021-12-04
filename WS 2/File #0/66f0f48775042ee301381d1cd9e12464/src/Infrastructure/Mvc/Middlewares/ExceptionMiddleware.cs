using System;
using System.Threading.Tasks;
using Infrastructure.Mvc.Abstractions;

namespace Infrastructure.Mvc.Middlewares
{
    public class ExceptionMiddleware : Middleware
    {
        private readonly IExceptionHandler _exceptionHandler;
        public ExceptionMiddleware(IExceptionHandler exceptionHandler)
        {
            _exceptionHandler = exceptionHandler;
        }

        public override Task Handle(ConsoleContext context)
        {
            try
            {
                return Next.Handle(context);
            }
            catch (Exception e)
            {
                return _exceptionHandler.HandleError(context, e);
            }
        }
    }
}
