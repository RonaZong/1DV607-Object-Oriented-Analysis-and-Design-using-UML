package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members = new ArrayList<>();
    private Member member;

    public BoatClub() {
    }

    public void creatMember(String userName, String personalNumber){
        if (this.member == null) {
            Member newMember = new Member(userName, personalNumber);
            members.add(newMember);
        }
        else {
            this.member.editMember(userName, personalNumber);
        }
    }

    public void updateMemberInformation(Member member, String name, String personalNumber){
        if(name.length() >1)
            member.setName(name);
        if(personalNumber.length() >1)
            member.setPersonalNumber(personalNumber);
    }

    public void deleteMember(Member member){
        members.remove(member);
    }

    public ArrayList<Member> getAllMember(){
        return this.members;
    }


}
