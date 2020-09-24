package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members;

    public BoatClub() {
    }

    public void creatMember(String userName, String personalNumber){
        Member member = new Member(userName,personalNumber);

    }

    public ArrayList<Member> getAllMember(){
        return this.members;
    }
}
