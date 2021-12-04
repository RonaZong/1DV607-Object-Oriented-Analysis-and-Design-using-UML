using System;
using Core.Application.Abstractions;
using Core.Domain.VO;

namespace Core.Application.Models
{
    /// <summary>
    ///     Register a new boat request.
    /// </summary>
    public class BoatRegisterRequest : IValidatable
    {
        /// <summary>
        /// Initializes a new instance of the
        ///     <see cref="BoatRegisterRequest"/> class.
        /// </summary>
        /// <param name="memberId">The member id.</param>
        /// <param name="boatType">The boat type.</param>
        /// <param name="length">The boat length.</param>
        public BoatRegisterRequest(int memberId, string boatType, int length)
        {
            MemberId = memberId;
            BoatType = boatType;
            Length = length;
        }

        /// <summary>
        ///     The member id.
        /// </summary>
        public int MemberId { get; }

        /// <summary>
        ///     The boat type.
        /// </summary>
        public string BoatType { get; }

        /// <summary>
        ///     The boat length.
        /// </summary>
        public int Length { get; }

        /// <inheritdoc/>
        public IValidationResult Validate()
        {
            if (MemberId <= 0)
                return ValidationResult.Failure("Member ID must be greater than 0");
            if (Length <= 0)
                return ValidationResult.Failure("Boat length must be greater than 0");
            if (string.IsNullOrWhiteSpace(BoatType))
                return ValidationResult.Failure("Boat type must be set");
            if (! Enum.TryParse(typeof(BoatType), BoatType, out _))
                return ValidationResult.Failure(
                    string.Format(
                        "Boat type must be one of {0}",
                        string.Join(
                            ", ", (BoatType[])Enum.GetValues(typeof(BoatType)))));
            return ValidationResult.Success;
        }
    }
}
