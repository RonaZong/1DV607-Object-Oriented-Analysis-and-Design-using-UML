package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members=new ArrayList<>();
    private Registry registry;
    //we can discuss if need this as an attribute or not(I added for showing the information of member deleted as a confirmation msg)line 38
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


    public Member deleteMember(Member member){
        this.member = member;
        members.remove(member);
        //I used here to return that member who was deleted
        return this.member;
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

        return registry.loadForCompactList(registry.verboseList("VerboseList.txt"));
    }

   /* public Iterable<Member> getAllMembersForVerboseList(){
        Registry vb= new Registry();
        return vb.loadForVerboseList(vb.verboseList("VerboseList.txt"));
    }*/

    public void loadAllInformationOfMembers(Registry list){
        this.members = (ArrayList<Member>) list.loadForVerboseList(list.verboseList("VerboseList.txt"));
//        for (Member member: this.members) {
//            member.registerNewBoat();
//
//        }
    }

    //enter a member name to get member
    public Member getMember(String memberName){
        for (Member m:this.members){
            if (memberName.equals(memberName)){
                return m;
            }
        }
        return null;
    }
}
