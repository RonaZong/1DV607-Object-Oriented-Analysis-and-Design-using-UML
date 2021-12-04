using System.Collections.Generic;
using System.Threading.Tasks;
using AutoMapper;
using Core.Application.Abstractions;
using Core.Application.Models;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;
using UI.Models;
using UI.View.Members;
using UI.View.Shared;

namespace UI.Controllers
{
    /// <summary>
    ///     Handles requests for any member operation.
    /// </summary>
    [Secured, Controller]
    public class MemberController
    {
        /// <summary>
        ///     The <see cref="IMemberService"/>.
        /// </summary>
        private readonly IMemberService _memberService;

        /// <summary>
        ///     The <see cref="IMapper"/>.
        /// </summary>
        private readonly IMapper _mapper;

        /// <summary>
        ///     Initializes a new instance of the <see cref="MemberController"/>
        ///     class.
        /// </summary>
        /// <param name="memberService">The member service.</param>
        /// <param name="mapper">The view model mapper.</param>
        public MemberController(IMemberService memberService, IMapper mapper)
        {
            _memberService = memberService;
            _mapper = mapper;
        }

        /// <summary>
        ///     Returns a member by the specified <paramref name="id"/>.
        /// </summary>
        /// <param name="id"><The member id./param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Get member details")]
        public async Task<IView> Get([Description("member id")] int id = 0)
        {
            var response = await _memberService.Get(id);
            return response.Match<IView>(
                Some: member => new MemberDetailsView(
                    _mapper.Map<MemberViewModel>(member)),
                None: () => new MemberNotFoundView());
        }

        /// <summary>
        ///     Returns a collection of members.
        /// </summary>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("List members")]
        public async Task<IView> List()
        {
            var members = await _memberService.List();
            return new MemberListView(_mapper.Map<List<MemberViewModel>>(members));
        }

        /// <summary>
        ///     Registers a new member with the specified
        ///     <paramref name="name"/> and
        ///     <paramref name="personalIdentityNumber"/>.
        /// </summary>
        /// <param name="name">The member name.</param>
        /// <param name="personalIdentityNumber">
        ///     The personal identity number.
        /// </param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Register member")]
        public async Task<IView> Register(
            [Parameter("n"), Description("name")] string name,
            [Parameter("pin"), Description("pers.id")] string personalIdentityNumber)
        {
            var response = await _memberService.Register(
                new MemberRegisterRequest(name, personalIdentityNumber));
            return response.Match(
                Right: member => Get(member.Id).Result,
                Left: error => new ErrorView(error.ErrorMessage));
        }

        /// <summary>
        ///     Updates an already registered member details with the specified
        ///     <paramref name="name"/> and
        ///     <paramref name="personalIdentityNumber"/>.
        /// </summary>
        /// <param name="id">The member id to update.</param>
        /// <param name="name">The new name (optional).</param>
        /// <param name="personalIdentityNumber">
        ///     The new personal identity number (optional).
        /// </param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Update member")]
        public async Task<IView> Update(
            [Parameter("id"), Description("member id")] int memberId,
            [Parameter("n"), Description("name")] string name = null,
            [Parameter("pin"), Description("pers.id")] string personalIdentityNumber = null)
        {
            var response = await _memberService.Update(
                new MemberUpdateRequest(memberId, name, personalIdentityNumber));
            return response.Match(
                Right: member => Get(member.Id).Result,
                Left: error => new ErrorView(error.ErrorMessage));
        }

        /// <summary>
        ///     Deletes a member with the specified
        ///     <paramref name="memberId"/>.
        /// </summary>
        /// <param name="memberId">The member id.</param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Delete member")]
        public async Task<IView> Delete(
            [Parameter("id"), Description("member id")] int memberId)
        {
            var response = await _memberService.Delete(
                new MemberDeleteRequest(memberId));
            return response.Match<IView>(
                Some: error => new ErrorView(error),
                None: () => new MemberDeletedView());
        }
    }
}
