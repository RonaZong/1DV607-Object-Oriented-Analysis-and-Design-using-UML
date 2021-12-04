using Alba.CsConsoleFormat;
using Infrastructure.Mvc.Abstractions;

namespace UI.View.Shared
{
    /// <summary>
    ///     Generic information view.
    /// </summary>
    public class InformationView : IView
    {
        /// <summary>
        ///     The information message.
        /// </summary>
        private readonly string _message;

        /// <summary>
        ///     Initializes a new instance of the <see cref="InformationView"/>
        ///     class.
        /// </summary>
        /// <param name="message">The information message.</param>
        public InformationView(string message)
        {
            _message = message;
        }

        /// <inheritdoc/>
        public void Render()
        {
            var document = new InformationTableBuilder()
                .AddHeader("INFORMATION")
                .AddRow(new[] { _message })
                .Build();
            ConsoleRenderer.RenderDocument(document);
        }
    }
}
