using System;
using System.Security.Cryptography;
using Microsoft.AspNetCore.Cryptography.KeyDerivation;

namespace Infrastructure.Data.Utils
{
    /// <summary>
    ///     A PBKDF2 password hasher utility class.
    /// </summary>
    internal static class Pbkdf2PasswordHasher
    {
        /// <summary>
        ///     Hashed a password.
        /// </summary>
        /// <param name="password">The password to be hashed.</param>
        /// <returns>The password hash.</returns>
        public static string Hash(string password)
        {
            const int iterations = 100000;
            var salt = new byte[128 / 8];
            using var rng = RandomNumberGenerator.Create();
            rng.GetBytes(salt);
            return Hash(password, salt, iterations);
        }

        /// <summary>
        ///     Hashes a plain text password according to the PBKDF2 algorithm
        ///     with the specified <paramref name="salt"/> and
        ///     <paramref name="iterations"/>.
        /// </summary>
        /// <param name="password">The plain text password.</param>
        /// <param name="salt">The random password salt.</param>
        /// <param name="iterations">The iteration count.</param>
        /// <returns>The password hash.</returns>
        public static string Hash(
            string password, byte[] salt, int iterations)
        {
            var hash = Convert.ToBase64String(KeyDerivation.Pbkdf2(
                password,
                salt,
                KeyDerivationPrf.HMACSHA1,
                iterations,
                256 / 8));
            return $"{iterations}.{hash}.{Convert.ToBase64String(salt)}";
        }

        /// <summary>
        ///     Returns whether or not the plain text password matches a hashed
        ///     password.
        /// </summary>
        /// <param name="plaintextPassword">The plain text password.</param>
        /// <param name="hashedPassword">The hashed password.</param>
        /// <returns>
        ///     <c>true</c> if the plain text password match the hashed
        ///     password; <c>false</c> otherwise.
        /// </returns>
        public static bool IsMatch(
            string plainTextPassword, string hashedPassword)
        {
            var iterations = int.Parse(hashedPassword.Split('.')[0]);
            var salt = Convert.FromBase64String(hashedPassword.Split('.')[2]);
            return hashedPassword == Hash(plainTextPassword, salt, iterations);
        }
    }

}
