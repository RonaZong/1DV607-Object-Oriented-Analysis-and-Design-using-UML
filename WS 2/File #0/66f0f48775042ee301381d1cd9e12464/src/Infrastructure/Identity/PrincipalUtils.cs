using System.Security.Principal;

namespace Infrastructure.Identity
{
    public static class PrincipalUtils
    {
        public static IPrincipal Anonymous()
        {
            return new GenericPrincipal(
                new GenericIdentity(string.Empty), new string[] { });
        }
    }
}
