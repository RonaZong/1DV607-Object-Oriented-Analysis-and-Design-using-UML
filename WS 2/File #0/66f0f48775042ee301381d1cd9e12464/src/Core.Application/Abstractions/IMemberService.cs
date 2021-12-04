using System.Collections.Generic;
using System.Threading.Tasks;
using Core.Application.Models;
using Core.Domain.Entities;
using LanguageExt;

namespace Core.Application.Abstractions
{
    public interface IMemberService : IService
    {
        Task<Option<Member>> Get(int memberId);
        Task<IEnumerable<Member>> List();
        Task<Either<IValidationError, Member>> Register(MemberRegisterRequest request);
        Task<Either<IValidationError, Member>> Update(MemberUpdateRequest request);
        Task<Option<IValidationError>> Delete(MemberDeleteRequest request);
    }
}
