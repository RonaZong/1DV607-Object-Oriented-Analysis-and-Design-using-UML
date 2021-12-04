using System.Threading.Tasks;

namespace Infrastructure.Mvc.Abstractions
{
    public interface IMiddleware
    {
        void Register(IMiddleware next);
        Task Handle(ConsoleContext context);
    }
}
