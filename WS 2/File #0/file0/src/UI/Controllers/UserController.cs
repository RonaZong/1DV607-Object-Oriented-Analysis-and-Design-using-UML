using System.Collections.Generic;
using System.Threading.Tasks;
using AutoMapper;
using Infrastructure.Identity;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;
using UI.Models;
using UI.View.Users;

namespace UI.Controllers
{
    /// <summary>
    ///     Handles application users.
    /// </summary>
    [Secured, Controller]
    public class UserController
    {
        /// <summary>
        ///     The <see cref="IUserManager"/>.
        /// </summary>
        private readonly IUserManager _manager;

        /// <summary>
        ///     The <see cref="IMapper"/>.
        /// </summary>
        private readonly IMapper _mapper;

        /// <summary>
        ///     Initializes a new instance of the <see cref="UserController"/>
        ///     class.
        /// </summary>
        /// <param name="manager">The <see cref="IUserManager"/>.</param>
        /// <param name="mapper">The <see cref="IMapper"/>.</param>
        public UserController(IUserManager manager, IMapper mapper)
        {
            _manager = manager;
            _mapper = mapper;
        }

        /// <summary>
        ///     Returns all registered application users.
        /// </summary>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("List application users")]
        public async Task<IView> List()
        {
            var users = await _manager.List();
            var vm = _mapper.Map<IEnumerable<UserViewModel>>(users);
            return new UserListView(vm);
        }
    }
}
