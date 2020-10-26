package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoatClub {
    private Map<Integer, Member> membersMap = new HashMap<>();
    private ArrayList<Member> members;
    private Member member;
    private int memberID ;

    public BoatClub() {
        this.members = new ArrayList<>();
        this.memberID = 0;
    }

    public String memberToString(int memberID) {
        if( (membersMap.size() > 0) && (memberID <= membersMap.size()) )
            return membersMap.get(memberID).toStringExtended(false);
        else
            return "\nNo member found. Please create new member.";
    }

    public void addMember() {
        this.members.add(this.member);
    }

    public void creatMember(String personalNumber, String userName, String password){
        memberID++;
        Member newMember = new Member(personalNumber, userName,password);
        this.member = newMember;
        addMember();
        this.membersMap.put(this.memberID, this.member);
    }

    // Update Member
    public void updateMember(int memberID, String personalNumber, String name, String password){
        membersMap.get(memberID).setPersonalNumber(personalNumber);
        membersMap.get(memberID).setName(name);
        membersMap.get(memberID).setPassword(password);
    }

    public void deleteMember(Member member){
        this.members.remove(member);
        this.membersMap.remove(member.getMemberID());
    }

    public ArrayList<Member> getAllMember(){
        return this.members;
    }


}
