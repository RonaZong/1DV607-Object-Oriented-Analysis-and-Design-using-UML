using System;
using System.Security.Principal;

namespace Infrastructure.Session.Abstractions
{
    public interface ISession
    {
        Guid Id { get; }
        IPrincipal User { get; set; }
    }
}
