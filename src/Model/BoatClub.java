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

    public void deleteMember(Member member){
        members.remove(member);
    }

    public ArrayList<Member> getAllMember(){
        return this.members;
    }

    public void updateMemberInformation(Member member , String name , String personalNumber){
        if(name.length() >1)
            member.setName(name);
        if(personalNumber.length() >1)
            member.setPersonalNumber(personalNumber);
    }
}
