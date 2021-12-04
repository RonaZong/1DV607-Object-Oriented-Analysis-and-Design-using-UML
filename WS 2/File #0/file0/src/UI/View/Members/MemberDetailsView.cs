using Alba.CsConsoleFormat;
using Infrastructure.Mvc.Abstractions;
using UI.Models;
using UI.View.Shared;

namespace UI.View.Members
{
    /// <summary>
    ///     Displays member details.
    /// </summary>
    public class MemberDetailsView : IView
    {
        /// <summary>
        ///     The member view model.
        /// </summary>
        private readonly MemberViewModel _member;

        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberDetailsView"/> class.
        /// </summary>
        /// <param name="member">The member model.</param>
        public MemberDetailsView(MemberViewModel member)
        {
            _member = member;
        }

        /// <inheritdoc/>
        public void Render()
        {
            var builder = new TableBuilder();
            if (_member == null)
            {
                builder
                    .AddHeaders(new[] { "INFORMATION" })
                    .AddRow(new[] { "No user found!" });
            }
            else
            {
                builder
                    .AddHeaders(new[] { "ID", "NAME", "PERSONAL IDENTITY NUMBER" })
                    .AddRow(new object[] {
                        _member.Id,
                        _member.Name,
                        _member.PersonalIdentityNumber
                    });
            }
            ConsoleRenderer.RenderDocument(builder.Build());
        }
    }
}
