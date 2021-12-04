using System.Linq;
using AutoMapper;
using Core.Domain.Entities;
using UI.Models;

namespace UI.Mappings
{
    /// <summary>
    ///     Entity to ViewModel (DTO) mappings.
    /// </summary>
    public sealed class ViewModelMappingProfiles : Profile
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="ViewModelMappingProfiles"/> class.
        /// </summary>
        public ViewModelMappingProfiles()
        {
            CreateMap<Member, MemberViewModel>()
                .ConstructUsing((src, ctx) => new MemberViewModel(
                    src.Id,
                    src.Name,
                    src.PersonalIdentityNumber,
                    src.Boats?.Count() ?? 0));
            CreateMap<User, UserViewModel>()
                .ConstructUsing((src, ctx) => new UserViewModel(
                    src.Id,
                    src.Username,
                    src.Password.Value,
                    src.TwoFactor?.IsEnabled ?? false));
        }
    }
}
