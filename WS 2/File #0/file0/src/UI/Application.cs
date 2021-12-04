using System;
using System.Collections.Generic;
using System.Reflection;
using System.Threading;
using System.Threading.Tasks;
using Infrastructure.Mvc;
using Infrastructure.Mvc.Abstractions;
using Infrastructure.Mvc.Attributes;
using Infrastructure.Mvc.Routing;
using Infrastructure.Session.Abstractions;
using Microsoft.Extensions.Hosting;
using Console = Infrastructure.IO.ColoredConsole;

namespace UI
{
    /// <inheritdoc/>
    public sealed class Application : IHostedService
    {
        /// <summary>
        ///     The <see cref="IApplicationBuilder"/>.
        /// </summary>
        private readonly IApplicationBuilder _applicationBuilder;

        /// <summary>
        ///     The <see cref="ISession"/>.
        /// </summary>
        private readonly ISession _session;

        /// <summary>
        ///     Initializes a new instance of the <see cref="Application"/>
        ///     class.
        /// </summary>
        /// <param name="applicationBuilder">
        ///     The <see cref="IApplicationBuilder"/>.
        /// </param>
        /// <param name="session">The <see cref="ISession"/>.</param>
        public Application(IApplicationBuilder applicationBuilder, ISession session)
        {
            _applicationBuilder = applicationBuilder;
            _session = session;
        }

        /// <inheritdoc/>
        public async Task StartAsync(CancellationToken cancellationToken)
        {
            await Run(cancellationToken);
        }

        /// <inheritdoc/>
        public Task StopAsync(CancellationToken cancellationToken)
        {
            return Task.CompletedTask;
        }

        /// <summary>
        ///     Runs the application and continuously listens to commands
        ///     entered to to CLI. 
        /// </summary>
        /// <param name="cancellationToken">The cancellation token.</param>
        /// <returns>
        ///     A <see cref="Task"/> representing the asynchronous operation.
        /// </returns>
        private async Task Run(CancellationToken cancellationToken)
        {
            Console.WriteLine("                                                                            ");
            Console.WriteLine(" ██╗   ██╗ █████╗  ██████╗██╗  ██╗████████╗ ██████╗██╗     ██╗   ██╗██████╗ ");
            Console.WriteLine(" ╚██╗ ██╔╝██╔══██╗██╔════╝██║  ██║╚══██╔══╝██╔════╝██║     ██║   ██║██╔══██╗");
            Console.WriteLine("  ╚████╔╝ ███████║██║     ███████║   ██║   ██║     ██║     ██║   ██║██████╔╝");
            Console.WriteLine("   ╚██╔╝  ██╔══██║██║     ██╔══██║   ██║   ██║     ██║     ██║   ██║██╔══██╗");
            Console.WriteLine("    ██║   ██║  ██║╚██████╗██║  ██║   ██║   ╚██████╗███████╗╚██████╔╝██████╔╝");
            Console.WriteLine("    ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝╚══════╝ ╚═════╝ ╚═════╝ ");
            Console.WriteLine("                                                                            ");

            PrintMenu(_applicationBuilder.Endpoints);

            var pipeline = _applicationBuilder.Build();
            while (!cancellationToken.IsCancellationRequested)
            {
                if (!Console.KeyAvailable())
                {
                    continue;
                }
                var input = Console.ReadLine(ConsoleColor.Yellow);
                Console.EmptyLine();
                if (cancellationToken.IsCancellationRequested)
                {
                    break;
                }
                try
                {
                    var context = new ConsoleContext(_session, ConsoleRequest.Parse(input));
                    await pipeline(context);
                }
                catch (Exception e)
                {
                    Console.Exception(e);
                }
                finally
                {
                    Console.EmptyLine();
                }
            }
        }

        // TODO: Remove this - use a table builder.
        private static void PrintMenu(IDictionary<string, Endpoint> endpoints)
        {
            const string format = "{0, -20} {1, -50} {2}";

            Console.WriteLine(ConsoleColor.Yellow, format, "COMMAND", "ARGUMENT(S)", "DESCRIPTION");

            foreach (var e in endpoints)
            {
                var methodDescAttr = e.Value.Method.GetCustomAttribute<DescriptionAttribute>();
                var arguments = new List<string>();
                foreach (var j in e.Value.Method.GetParameters())
                {
                    var attr = j.GetCustomAttribute<ParameterAttribute>();
                    var descAttr = j.GetCustomAttribute<DescriptionAttribute>();
                    var name = attr?.Name ?? j.Name;
                    var description = descAttr?.Value ?? "";
                    arguments.Add($"-{name} ({description})");
                }
                Console.WriteLine(format, e.Key, string.Join(" ", arguments), methodDescAttr?.Value);
            }
            Console.EmptyLine();
        }
    }
}
