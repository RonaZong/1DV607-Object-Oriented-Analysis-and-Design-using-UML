using System;
using System.Collections.Generic;
using System.Security.Principal;
using Infrastructure.Identity;
using Infrastructure.Session.Abstractions;

namespace Infrastructure.Session
{
    public class ConsoleSession : ISession
    {
        public ConsoleSession()
        {
            Id = Guid.NewGuid();
            User = PrincipalUtils.Anonymous();
        }

        public Guid Id { get; }

        public IPrincipal User { get; set; }
    }
}
