package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members=new ArrayList<>();

    public BoatClub() {
    }

    public void creatMember(String userName, String personalNumber){
        Member member = new Member(userName,personalNumber);
        members.add(member);

    }

    public ArrayList<Member> getAllMember(){
        return this.members;
    }
}
