package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members=new ArrayList<>();
    private Registry registry;

    public BoatClub() {
    }

    public Member creatMember(String userName, String personalNumber){
        Member member = new Member(userName,personalNumber);
        //CompactListSave save = new CompactListSave();
        members.add(member);

       // save.saveFileOnCompactList(member);

        return member;
    }

    public void saveOnVerboseList(Member member){
        registry = new Registry();
        registry.saveFileOnCompactList(member);
    }

   /* public void saveOnCompactList(Member member){
        VerboseListSave save = new VerboseListSave();
        save.saveFileOnCompactList(member);
    }*/

    public void deleteMember(Member member){
        members.remove(member);
    }


    public void updateMemberInformation(Member member , String name , String personalNumber){
        if(name.length() >0)
            member.setName(name);
        if(personalNumber.length() >0)
            member.setPersonalNumber(personalNumber);
    }


    public Iterable<Member> getAllMembersFromRegistry(){
       // compactSave = new CompactListSave();
        registry = new Registry();

        return registry.readyToPrintForCompactList(registry.verboseList("VerboseList.txt"));
    }

    public Iterable<Member> getAllMembersForVerboseList(){
        Registry vb= new Registry();
        return vb.readyToPrintForVerboseList(vb.verboseList("VerboseList.txt"));
    }

    public void loadFromCompactList(Registry list){
        this.members= (ArrayList<Member>) list.readyToPrintForCompactList(list.verboseList("VerboseList.txt"));
    }

    //enter a member name to get member
    public Member getMember(String memberName){
        for (Member m:members){
            if (memberName.equals(memberName)){
                return m;
            }
        }
        return null;
    }
}
