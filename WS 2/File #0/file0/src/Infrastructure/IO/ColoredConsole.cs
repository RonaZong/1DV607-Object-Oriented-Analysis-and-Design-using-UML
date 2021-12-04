using System;

namespace Infrastructure.IO
{
    // FIXME: Remove ColoredConsole
    public static class ColoredConsole
    {
        public static bool KeyAvailable()
        {
            return Console.KeyAvailable;
        }

        public static void EmptyLine()
        {
            Console.WriteLine();
        }

        public static void WriteLine(object value)
        {
            Console.WriteLine(value);
        }

        public static void WriteLine(string format, object arg0)
        {
            Console.WriteLine(format, arg0);
        }

        public static void WriteLine(string format, params object[] args)
        {
            Console.WriteLine(format, args);
        }

        public static void WriteLine(ConsoleColor color, string format, params object[] args)
        {
            Colorize(color, () => Console.WriteLine(format, args));
        }

        public static void Muted(string str)
        {
            Colorize(ConsoleColor.Gray, () => Console.WriteLine(str));
        }

        public static void Information(string str)
        {
            Colorize(ConsoleColor.Blue, () => Console.WriteLine(str));
        }

        public static void Error(string str)
        {
            Colorize(ConsoleColor.Red, () => Console.WriteLine(str));
        }

        public static void Exception(Exception exception)
        {
            Colorize(ConsoleColor.Red, () => Console.WriteLine(exception?.Message ?? ""));
            Colorize(ConsoleColor.Red, () => Console.WriteLine(exception?.StackTrace ?? ""));
        }

        public static string ReadLine(ConsoleColor color)
        {
            Console.ForegroundColor = color;
            var input = Console.ReadLine();
            Console.ResetColor();
            return input;
        }

        private static void Colorize(ConsoleColor color, Action action)
        {
            Console.ForegroundColor = color;
            action();
            Console.ResetColor();
        }
    }
}
