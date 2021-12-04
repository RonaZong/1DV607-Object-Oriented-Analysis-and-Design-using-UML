using System;
using System.Threading.Tasks;

namespace Infrastructure.Mvc.Middlewares
{
    public class EndMiddleware : Middleware
    {
        public override Task Handle(ConsoleContext context)
        {
            Console.WriteLine("Not found!");
            return Task.CompletedTask;
        }
    }
}
