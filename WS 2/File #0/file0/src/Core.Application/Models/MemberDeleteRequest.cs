namespace Core.Application.Models
{
    /// <summary>
    ///     Deletes a member by id.
    /// </summary>
    public class MemberDeleteRequest
    {
        /// <summary>
        ///     Initializes a new instance of the
        ///     <see cref="MemberDeleteRequest"/> class.
        /// </summary>
        /// <param name="memberId"></param>
        public MemberDeleteRequest(int memberId)
        {
            MemberId = memberId;
        }

        /// <summary>
        ///     The member id.
        /// </summary>
        public int MemberId { get; }
    }
}
