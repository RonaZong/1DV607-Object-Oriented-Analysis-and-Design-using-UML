using System.Threading.Tasks;
using Core.Application.Abstractions;
using Core.Application.Models;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;
using UI.View.Boats;
using UI.View.Shared;

namespace UI.Controllers
{
    /// <summary>
    ///     Handles requests for any boat operation.
    /// </summary>
    [Secured, Controller]
    public class BoatController
    {
        /// <summary>
        ///     The <see cref="IBoatService"/>.
        /// </summary>
        private readonly IBoatService _boatService;

        /// <summary>
        ///     Initializes a new instance of the <see cref="BoatController"/>
        ///     class.
        /// </summary>
        /// <param name="boatService">The boat service.</param>
        public BoatController(IBoatService boatService)
        {
            _boatService = boatService;
        }

        /// <summary>
        ///     Registers a new boat with the specified
        ///     <paramref name="memberId"/> and <paramref name="boatType"/>.
        /// </summary>
        /// <param name="memberId">The member id.</param>
        /// <param name="boatType">The boat type.</param>
        /// <param name="length">The boat length.</param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Register boat")]
        public async Task<IView> Register(
            [Parameter("id"), Description("member id")] int memberId,
            [Parameter("t"), Description("type")] string boatType,
            [Parameter("l"), Description("length")] int length)
        {
            var response = await _boatService.Register(
                new BoatRegisterRequest(memberId, boatType, length));
            return response.Match<IView>(
                Right: boat => new BoatRegisteredView(),
                Left: error => new ErrorView(error));
        }

        /// <summary>
        ///     Updates the boat details for the specified
        ///     <paramref name="memberId"/>.
        /// </summary>
        /// <param name="memberId">The member id.</param>
        /// <param name="boatType">The boat type.</param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Update boat")]
        public async Task<IView> Update(
            [Parameter("id"), Description("member id")] int memberId,
            [Parameter("t"), Description("type")] string boatType,
            [Parameter("l"), Description("length")] int length)
        {
            var response = await _boatService.Update(
                new BoatUpdateRequest(memberId, boatType, length));
            return response.Match<IView>(
                Right: boat => new BoatUpdatedView(),
                Left: error => new ErrorView(error));
        }

        /// <summary>
        ///     Deletes a boat with the specified
        ///     <paramref name="boatId"/>.
        /// </summary>
        /// <param name="boatId">The boat id.</param>
        /// <returns>
        ///     A <see cref="Task{IView}"/> representing the asynchronous
        ///     operation.
        /// </returns>
        [Description("Delete boat")]
        public async Task<IView> Delete(
            [Parameter("id"), Description("boat id")] int boatId)
        {
            var response = await _boatService.Delete(
                new BoatDeleteRequest(boatId));
            return response.Match<IView>(
                Some: error => new ErrorView(error),
                None: () => new BoatDeletedView());
        }
    }
}
