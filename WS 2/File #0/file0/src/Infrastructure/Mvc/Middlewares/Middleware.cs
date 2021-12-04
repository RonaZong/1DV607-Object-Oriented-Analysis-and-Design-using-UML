using System.Threading.Tasks;
using Infrastructure.Mvc.Abstractions;

namespace Infrastructure.Mvc.Middlewares
{
    public abstract class Middleware : IMiddleware
    {
        protected IMiddleware Next
        {
            get;
            private set;
        }

        public abstract Task Handle(ConsoleContext context);

        public void Register(IMiddleware next)
        {
            Next = next;
        }
    }
}
