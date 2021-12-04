using System;
using Core.Application.Abstractions;

namespace Core.Application.Models
{
    /// <summary>
    ///     Update member information request.
    /// </summary>
    public class MemberUpdateRequest : IValidatable
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberUpdateRequest"/> class.
        /// </summary>
        /// <param name="id">The member id.</param>
        /// <param name="name">The member name.</param>
        /// <param name="personalIdentityNumber">
        ///     The personal identity number.
        /// </param>
        public MemberUpdateRequest(
            int id, string name, string personalIdentityNumber)
        {
            Id = id;
            Name = name;
            PersonalIdentityNumber = personalIdentityNumber;
        }

        /// <summary>
        ///     Gets the member id.
        /// </summary>
        public int Id { get; }

        /// <summary>
        ///     Gets the member name.
        /// </summary>
        public string Name { get; }

        /// <summary>
        ///     Gets the personal identity number.
        /// </summary>
        public string PersonalIdentityNumber { get; }

        /// <inheritdoc/>
        public IValidationResult Validate()
        {
            if (Name != null && string.IsNullOrWhiteSpace(Name))
                return ValidationResult.Failure("Name must be set");
            if (PersonalIdentityNumber != null &&
                string.IsNullOrWhiteSpace(PersonalIdentityNumber))
                return ValidationResult.Failure("Personal Identity Number must be set");
            return ValidationResult.Success;
        }
    }
}
