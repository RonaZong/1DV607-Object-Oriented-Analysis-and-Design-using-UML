package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members;
    private Member member;

    public BoatClub() {
        this.members = new ArrayList<>();
    }

    // Register Member
    public void creatMember(String userName, String personalNumber){
        if (this.member == null) {
            Member newMember = new Member(userName, personalNumber);
            this.members.add(newMember);
        }
        else {
            this.member.editMember(userName, personalNumber);
        }
    }

    // Update Member
    public void updateMember(Member member, String name, String personalNumber){
        if(name.length() > 1)
            member.setName(name);
        if(personalNumber.length() >1)
            member.setPersonalNumber(personalNumber);
    }

    // Delete Member
    public void deleteMember(Member member){
        this.members.remove(member);
    }

    public ArrayList<Member> getAllMember(){
        return this.members;
    }


}
