package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members;
    private Member member;

    public BoatClub() {
        this.members = new ArrayList<>();
    }

    public void addMember() {
        this.members.add(this.member);
    }
    // Register Member
    public void creatMember(String personalNumber, String userName, String password){
        if (this.member == null) {
            Member newMember = new Member(personalNumber, userName,password);
            this.members.add(newMember);
        }
        else {
            this.member.editMember(personalNumber, userName, password);
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
