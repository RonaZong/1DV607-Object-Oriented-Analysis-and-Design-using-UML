using System.Collections.Generic;
using System.Threading.Tasks;
using Core.Application.Abstractions;
using Core.Application.Models;
using Core.Domain.Entities;
using Core.Domain.Repositories;
using LanguageExt;

namespace Core.Application.Services
{
    /// <inheritdoc/>
    public class MemberService : IMemberService
    {
        /// <summary>
        ///     The unit of work.
        /// </summary>
        private readonly IUnitOfWork _unitOfWork;

        /// <summary>
        ///     The member respository.
        /// </summary>
        private readonly IMemberRepository _repository;

        /// <summary>
        /// Initializes a new instance of the <see cref="MemberService"/> class.
        /// </summary>
        /// <param name="unitOfWork">The unit of work.</param>
        /// <param name="repository">The member repository.</param>
        public MemberService(
            IUnitOfWork unitOfWork,
            IMemberRepository repository)
        {
            _unitOfWork = unitOfWork;
            _repository = repository;
        }

        /// <inheritdoc/>
        public async Task<Either<IValidationError, Member>> Register(
            MemberRegisterRequest request)
        {
            var validated = request.Validate();
            if (! validated.IsValid)
            {
                return Prelude.Left(validated.Error);
            }
            var member = new Member
            {
                Name = request.Name,
                PersonalIdentityNumber = request.PersonalIdentityNumber
            };
            await _unitOfWork.BeginTransaction();
            _repository.RegisterNew(member);
            await _unitOfWork.Commit();
            return member;
        }

        /// <inheritdoc/>
        public async Task<Option<Member>> Get(int memberId)
        {
            return await _repository.Get(memberId);
        }

        /// <inheritdoc/>
        public async Task<IEnumerable<Member>> List()
        {
            return await _repository.List();
        }

        /// <inheritdoc/>
        public async Task<Either<IValidationError, Member>> Update(
            MemberUpdateRequest request)
        {
            var validated = request.Validate();
            if (!validated.IsValid)
            {
                return Prelude.Left(validated.Error);
            }
            var member = await _repository.Get(request.Id);
            member.Name = request.Name ?? member.Name;
            member.PersonalIdentityNumber = request.PersonalIdentityNumber ?? member.PersonalIdentityNumber;
            await _unitOfWork.BeginTransaction();
            _repository.RegisterUpdated(member);
            await _unitOfWork.Commit();
            return member;
        }

        /// <inheritdoc/>
        public async Task<Option<IValidationError>> Delete(
            MemberDeleteRequest request)
        {
            var member = await _repository.Get(request.MemberId);
            if (member is null)
            {
                return new ValidationError(
                    $"No member found for id: {request.MemberId}");
            }
            await _unitOfWork.BeginTransaction();
            _repository.RegisterDeleted(member);
            await _unitOfWork.Commit();
            return Option<IValidationError>.None;
        }
    }
}
