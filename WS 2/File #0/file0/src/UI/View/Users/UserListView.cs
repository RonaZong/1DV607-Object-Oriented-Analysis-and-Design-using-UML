using System.Collections.Generic;
using System.Linq;
using Alba.CsConsoleFormat;
using Infrastructure.Mvc.Abstractions;
using UI.Models;
using UI.View.Shared;

namespace UI.View.Users
{
    /// <summary>
    ///     Displays a list of users.
    /// </summary>
    public class UserListView : IView
    {
        /// <summary>
        ///     The user view model.
        /// </summary>
        private readonly IEnumerable<UserViewModel> _users;

        /// <summary>
        ///     Initializes a new instance of the <see cref="UserListView"/>
        ///     class.
        /// </summary>
        /// <param name="users">The member model.</param>
        public UserListView(IEnumerable<UserViewModel> users)
        {
            _users = users;
        }

        /// <inheritdoc/>
        public void Render()
        {
            var document = new TableBuilder()
                .AddHeaders(new[] {
                    "ID", "USERNAME", "PASSWORD HASH", "2FA ENABLED"
                })
                .AddRows(_users.Select(user =>
                    new object[]
                    {
                        user.Id,
                        user.Username,
                        user.PasswordHash,
                        user.Is2FaEnabled
                    }
                ))
                .Build();
            ConsoleRenderer.RenderDocument(document);
        }
    }
}
