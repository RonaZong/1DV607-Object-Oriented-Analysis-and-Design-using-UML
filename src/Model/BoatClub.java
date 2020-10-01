package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members=new ArrayList<>();
    private Registry registry;
    private Member member;

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
        registry.saveFile(member);
    }


    public void deleteMember(Member member){
//        this.member = member;
        registry = new Registry();
       this.members = registry.loadForVerboseList(registry.verboseList("VerboseList.txt"));
        this.members.remove(member);
        //I used here to return that member who was deleted
       // return this.member;
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
        return registry.loadForVerboseList(registry.verboseList("VerboseList.txt"));
    }


    public void loadAllInformationOfMembers(Registry list){
        this.members = list.loadForVerboseList(list.verboseList("VerboseList.txt"));
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

    public ArrayList<Member> getAllMembersLocally(){
        return this.members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
}
