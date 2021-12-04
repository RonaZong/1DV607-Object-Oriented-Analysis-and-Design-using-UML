using System;
using System.Collections.Generic;

namespace Core.Application.Abstractions
{
    // TODO: Move out.
    public interface IValidatable
    {
        IValidationResult Validate();
    }

    public interface IValidationError {
        string ErrorMessage { get; }
    }

    public interface IValidationResult
    {
        bool IsValid { get; }
        IValidationError Error { get; }
    }

    public class ValidationResult : IValidationResult
    {
        public static ValidationResult Success = new ValidationResult();
        private ValidationResult(IValidationError error = null)
        {
            IsValid = error is null;
            Error = error;
        }
        public bool IsValid { get; }
        public IValidationError Error { get; }

        public static ValidationResult Failure(string errorMessage)
        {
            return new ValidationResult(new ValidationError(errorMessage));
        }
    }

    public class ValidationError : IValidationError
    {
        public ValidationError(string errorMessage)
        {
            ErrorMessage = errorMessage;
        }
        public string ErrorMessage { get; }
    }
}
