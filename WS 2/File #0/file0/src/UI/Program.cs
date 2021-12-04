using System.Reflection;
using System.Threading.Tasks;
using AutoMapper;
using Core.Application;
using Core.Application.Abstractions;
using Core.Domain.Repositories;
using Infrastructure.Data;
using Infrastructure.Identity;
using Infrastructure.Mvc;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;
using Infrastructure.Mvc.Middlewares;
using Infrastructure.Session;
using Infrastructure.Session.Abstractions;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using TwoFactorAuthNet;
using TwoFactorAuthNet.Providers.Qr;

namespace UI
{
    /// <summary>
    ///     The program start.
    /// </summary>
    public static class Program
    {
        /// <summary>
        ///     The main entry point of the program.
        /// </summary>
        /// <param name="args">The command line arguments.</param>
        /// <returns>
        ///     A <see cref="Task"/> representing the asynchronous operation.
        /// </returns>
        private static async Task Main(string[] args)
        {
            var host = CreateHostBuilder(args).Build();
            var app = host.Services.GetService<IApplicationBuilder>();
            app.SeedDatabase();
            app.UseMiddleware<ExceptionMiddleware>();
            app.UseMiddleware<RouteMiddleware>();
            app.UseMiddleware<AuthenticationMiddleware>();
            app.UseMiddleware<EndpointMiddleware>();
            app.UseEndpoints();
            await host.RunAsync();
        }

        /// <summary>
        ///     Creates the <see cref="IHostBuilder"/> and registers all
        ///     services in the container.
        /// </summary>
        /// <param name="args">The command line arguments.</param>
        /// <returns>A <see cref="IHostBuilder"/>.</returns>
        private static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureLogging(config => { config.ClearProviders(); })
                .ConfigureServices(services => {
                    const string ApplicationName = "TheJollyPirate"; 
                    services.AddDataProtection(config =>
                    {
                        config.ApplicationDiscriminator = ApplicationName;
                    });
                    services.AddSingleton<IApplicationBuilder, ApplicationBuilder>();
                    services.AddSingleton<ISession, ConsoleSession>();
                    services.AddSingleton<IAuthenticationManager, AuthenticationManager>();
                    services.AddSingleton<IUserManager, UserManager>();
                    services.AddHostedService<Application>();
                    services.AddSingleton<IExceptionHandler, ExceptionHandler>();
                    services.AddSingleton(new TwoFactorAuth(
                        ApplicationName,
                        qrcodeprovider: new QrServerQrCodeProvider()));
                    services.Scan(scan =>
                    {
                        scan
                            .FromAssemblies(Assembly.GetExecutingAssembly())
                                .AddClasses(classes => classes.WithAttribute<ControllerAttribute>())
                                    .AsSelfWithInterfaces()
                                    .WithScopedLifetime()
                            .FromAssemblies(typeof(IService).Assembly)
                                .AddClasses(classes => classes.AssignableTo<IService>())
                                    .AsSelfWithInterfaces()
                                    .WithScopedLifetime()
                            .FromAssemblies(typeof(ApplicationBuilder).Assembly)
                                .AddClasses(classes => classes.AssignableTo(typeof(IRepository<>)))
                                    .AsSelfWithInterfaces()
                                    .WithScopedLifetime();
                    });
                    const string connectionString = "Data Source=yachtclub.db";
                    services
                         .AddDbContext<YachtClubContext>(
                            options => {
                                options.UseSqlite(connectionString);
                                options.EnableSensitiveDataLogging();
                            });
                    services.AddScoped<IUnitOfWork, YachtClubContext>(x =>
                    {
                        return x.GetService<YachtClubContext>();
                    });
                    services.AddAutoMapper(Assembly.GetExecutingAssembly());
                })
                .UseConsoleLifetime(options => {
                    options.SuppressStatusMessages = false;
                });
    }
}
