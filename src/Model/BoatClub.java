package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members=new ArrayList<>();

    public BoatClub() {
    }

    public void creatMember(String userName, String personalNumber){
        Member member = new Member(userName,personalNumber);
        members.add(member);
        CompactListSave save = new CompactListSave();
        save.saveFileOnCompactList(members);

    }

    public void deleteMember(Member member){
        members.remove(member);
    }



    public void updateMemberInformation(Member member , String name , String personalNumber){
        if(name.length() >0)
            member.setName(name);
        if(personalNumber.length() >0)
            member.setPersonalNumber(personalNumber);
    }

    public Iterable<Member> getAllMembers(){
        return members;
    }
}
