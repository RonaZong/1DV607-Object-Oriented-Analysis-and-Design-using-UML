using System.Threading.Tasks;
using Core.Application.Models;
using Core.Domain.Entities;
using LanguageExt;

namespace Core.Application.Abstractions
{
    public interface IBoatService : IService
    {
        Task<Either<IValidationError, Boat>> Register(BoatRegisterRequest request);
        Task<Either<IValidationError, Boat>> Update(BoatUpdateRequest request);
        Task<Option<IValidationError>> Delete(BoatDeleteRequest request);
    }
}
