using System;
using System.Threading.Tasks;
using Core.Application.Abstractions;
using Core.Application.Models;
using Core.Domain.Entities;
using Core.Domain.Repositories;
using Core.Domain.VO;
using LanguageExt;

namespace Core.Application.Services
{
    /// <inheritdoc/>
    public class BoatService : IBoatService
    {
        /// <summary>
        ///     The unit of work.
        /// </summary>
        private readonly IUnitOfWork _unitOfWork;

        /// <summary>
        ///     The member respository.
        /// </summary>
        private readonly IMemberRepository _memberRepository;

        /// <summary>
        ///     The boat respository.
        /// </summary>
        private readonly IBoatRepository _boatRepository;

        /// <summary>
        ///     Initializes a new instance of the <see cref="BoatService"/>
        ///     class.
        /// </summary>
        /// <param name="unitOfWork">The unit of work.</param>
        /// <param name="repository">The boat repository.</param>
        public BoatService(
            IUnitOfWork unitOfWork,
            IMemberRepository memberRepository,
            IBoatRepository boatRepository)
        {
            _unitOfWork = unitOfWork; // TODO: Remove and wrap transactions via aspects
            _memberRepository = memberRepository;
            _boatRepository = boatRepository;
        }

        /// <inheritdoc/>
        /// TODO: Handle validation via aspects
        public async Task<Option<IValidationError>> Delete(
            BoatDeleteRequest request)
        {
            var boat = await _boatRepository.Get(request.BoatId);
            if (boat is null)
            {
                return new ValidationError(
                    $"No boat found for id: {request.BoatId}");
            }
            await _unitOfWork.BeginTransaction();
            _boatRepository.RegisterDeleted(boat);
            await _unitOfWork.Commit();
            return Option<IValidationError>.None;
        }

        /// <inheritdoc/>
        public async Task<Either<IValidationError, Boat>> Register(
            BoatRegisterRequest request)
        {
            var validated = request.Validate();
            if (!validated.IsValid)
            {
                return Prelude.Left(validated.Error);
            }
            var owner = await _memberRepository.Get(request.MemberId);
            if (owner is null)
            {
                return new ValidationError(
                    $"No member found for id: {request.MemberId}");
            }
            var boatType = (BoatType)Enum.Parse(typeof(BoatType), request.BoatType);
            var boat = new Boat(boatType, request.Length, owner);
            await _unitOfWork.BeginTransaction();
            _boatRepository.RegisterNew(boat);
            await _unitOfWork.Commit();
            return boat;
        }

        /// <inheritdoc/>
        public async Task<Either<IValidationError, Boat>> Update(
            BoatUpdateRequest request)
        {
            var validated = request.Validate();
            if (!validated.IsValid)
            {
                return Prelude.Left(validated.Error);
            }
            var boat = await _boatRepository.Get(request.BoatId);
            if (boat is null)
            {
                return new ValidationError(
                    $"No boat found for id: {request.BoatId}");
            }
            boat.Length = request.Length ?? boat.Length;
            boat.Type = (BoatType)Enum.Parse(typeof(BoatType), request.BoatType);
            await _unitOfWork.BeginTransaction();
            _boatRepository.RegisterUpdated(boat);
            await _unitOfWork.Commit();
            return boat;
        }
    }
}
