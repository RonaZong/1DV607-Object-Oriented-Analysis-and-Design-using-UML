using System;
using Core.Application.Abstractions;
using Core.Domain.VO;

namespace Core.Application.Models
{
    /// <summary>
    ///     Updates a boat.
    /// </summary>
    public class BoatUpdateRequest : IValidatable
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="BoatRegisterRequest"/> class.
        /// </summary>
        /// <param name="boatId">The boat id.</param>
        /// <param name="boatType">The boat length.</param>
        /// <param name="length"></param>
        public BoatUpdateRequest(int boatId, string boatType, int? length)
        {
            BoatId = boatId;
            BoatType = boatType;
            Length = length;
        }

        /// <summary>
        ///     The boat id.
        /// </summary>
        public int BoatId { get; }

        /// <summary>
        ///     The boat type.
        /// </summary>
        public string BoatType { get; }

        /// <summary>
        ///     The boat length.
        /// </summary>
        public int? Length { get; }

        /// <inheritdoc/>
        public IValidationResult Validate()
        {
            if (BoatId <= 0)
                return ValidationResult.Failure("Boat ID must be greater than 0");
            if (Length.HasValue && Length <= 0)
                return ValidationResult.Failure("Boat length must be greater than 0");
            if (BoatType != null && string.IsNullOrWhiteSpace(BoatType))
                return ValidationResult.Failure("Boat type must be set");
            if (BoatType != null && !Enum.TryParse(typeof(BoatType), BoatType, out _))
                return ValidationResult.Failure(
                    string.Format(
                        "Boat type must be one of {0}",
                        string.Join(
                            ", ", (BoatType[])Enum.GetValues(typeof(BoatType)))));
            return ValidationResult.Success;
        }
    }
}
