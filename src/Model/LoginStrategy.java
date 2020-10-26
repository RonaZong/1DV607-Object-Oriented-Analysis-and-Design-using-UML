package Model;

public class LoginStrategy {
    private Member member;

    public LoginStrategy(Member member) {

    }

    public boolean check(Member member) {
        return this.member.equals(member);
    }
}
