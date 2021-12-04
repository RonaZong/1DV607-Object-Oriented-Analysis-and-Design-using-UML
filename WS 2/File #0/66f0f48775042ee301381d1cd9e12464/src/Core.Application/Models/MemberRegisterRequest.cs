using Core.Application.Abstractions;

namespace Core.Application.Models
{
    /// <summary>
    ///     Register a new member request.
    /// </summary>
    public class MemberRegisterRequest : IValidatable
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberRegisterRequest"/> class.
        /// </summary>
        /// <param name="name">The member name.</param>
        /// <param name="personalIdentityNumber">
        ///     The personal identity number.
        /// </param>
        public MemberRegisterRequest(string name, string personalIdentityNumber)
        {
            Name = name;
            PersonalIdentityNumber = personalIdentityNumber;
        }

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
            if (string.IsNullOrWhiteSpace(Name))
                return ValidationResult.Failure("Name must be set");
            if (string.IsNullOrWhiteSpace(PersonalIdentityNumber))
                return ValidationResult.Failure("Personal Identity Number must be set");
            return ValidationResult.Success;
        }
    }
}
