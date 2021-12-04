using System.Collections.Generic;
using System.Linq;
using Alba.CsConsoleFormat;
using Infrastructure.Mvc.Abstractions;
using UI.Models;
using UI.View.Shared;

namespace UI.View.Members
{
    /// <summary>
    ///     Displays a list of members.
    /// </summary>
    public sealed class MemberListView : IView
    {
        /// <summary>
        ///     The member view model.
        /// </summary>
        private readonly IEnumerable<MemberViewModel> _members;

        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberListView"/> class.
        /// </summary>
        /// <param name="member">The member model.</param>
        public MemberListView(IEnumerable<MemberViewModel> members)
        {
            _members = members;
        }

        /// <inheritdoc/>
        public void Render()
        {
            var document = new TableBuilder()
                .AddHeaders(new[] {
                    "ID", "NAME", "PERSONAL IDENTITY NUMBER", "BOAT COUNT"
                })
                .AddRows(_members.Select(
                    member => new object[]
                    {
                        member.Id,
                        member.Name,
                        member.PersonalIdentityNumber,
                        member.BoatCount
                    }))
                .Build();
            ConsoleRenderer.RenderDocument(document);
        }
    }
}
