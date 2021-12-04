using Alba.CsConsoleFormat;
using Core.Application.Abstractions;
using Infrastructure.Mvc.Abstractions;

namespace UI.View.Shared
{
    /// <summary>
    ///     Generic error view within the MVC pipeline.
    /// </summary>
    public class ErrorView : IView
    {
        /// <summary>
        ///     The error message.
        /// </summary>
        private readonly string _message;

        /// <summary>
        ///     Initializes a new instance of the <see cref="ErrorView"/> class.
        /// </summary>
        /// <param name="message">The error message.</param>
        public ErrorView(string message)
        {
            _message = message;
        }

        /// <summary>
        ///     Initializes a new instance of the <see cref="ErrorView"/> class.
        /// </summary>
        /// <param name="error">The error.</param>
        public ErrorView(IValidationError error) : this(error.ErrorMessage)
        {
        }

        /// <inheritdoc/>
        public void Render()
        {
            var document = new ExceptionTableBuilder()
                .AddHeader("ERROR")
                .AddRow(new[] { _message })
                .Build();
            ConsoleRenderer.RenderDocument(document);
        }
    }
}
