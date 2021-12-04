using System.Collections.Generic;
using System.Linq;
using Core.Domain.Entities;
using Core.Domain.VO;
using Infrastructure.Data.VO;
using Infrastructure.Mvc.Abstractions;
using Microsoft.Extensions.DependencyInjection;

namespace Infrastructure.Data
{
    public static class ApplicationBuilderDatabaseExtensions
    {
        /// <summary>
        ///     Seeds the database with dummy data if no data already exists.
        /// </summary>
        /// <param name="app">The application builder.</param>
        /// <returns>The application builder.</returns>
        public static IApplicationBuilder SeedDatabase(
            this IApplicationBuilder app)
        {
            using var serviceScope = app.ServiceProvider
                    .GetRequiredService<IServiceScopeFactory>()
                    .CreateScope();
            using var context = serviceScope.ServiceProvider
                .GetService<YachtClubContext>();

            context.Database.EnsureCreated();

            if (! context.Users.Any())
            {
                context.Users.Add(new User
                {
                    Id = 1,
                    Username = "admin",
                    Password = PasswordHash.FromPlainText("password")
                });
            }

            if (! context.Members.Any())
            {
                var member = new Member
                {
                    Id = 1,
                    Name = "catn8r",
                    PersonalIdentityNumber = "191111111111",
                    Boats = new List<Boat>()
                };
                context.Members.Add(member);
                context.Boats.Add(new Boat
                {
                    Id = 1,
                    Type = BoatType.Sailboat,
                    Owner = member
                });
            }
            context.SaveChanges();

            return app;
        }
    }
}
