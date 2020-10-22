package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Dealer> members = new ArrayList<>();
    private Dealer member;

    public BoatClub() {
    }

    public void creatMember(String userName, String personalNumber){
        if (this.member == null) {
            Dealer newMember = new Dealer(userName, personalNumber);
            members.add(newMember);
        }
        else {
            this.member.editMember(userName, personalNumber);
        }
    }

    public void updateMemberInformation(Dealer member, String name, String personalNumber){
        if(name.length() >1)
            member.setName(name);
        if(personalNumber.length() >1)
            member.setPersonalNumber(personalNumber);
    }

    public void deleteMember(Dealer member){
        members.remove(member);
    }

    public ArrayList<Dealer> getAllMember(){
        return this.members;
    }


}
