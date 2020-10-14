package Model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members = new ArrayList<>();
    private Member member;

    public BoatClub() {
    }

<<<<<<< Updated upstream
    public void creatMember(String userName, String personalNumber){
        if (this.member == null) {
            Member newMember = new Member(userName, personalNumber);
            members.add(newMember);
        }
        else {
            this.member.editMember(userName, personalNumber);
        }
=======
    public Member creatMember(String userName, String personalNumber) {
        Member member = new Member(userName, personalNumber);
        return  member;
    }

    public Member addNewMember(Member member){
        //CompactListSave save = new CompactListSave();
        members.add(member);

       // save.saveFileOnCompactList(member);

        return member;
    }

    public Member makeMemberForLoadingInStartOfProgram(String name , String personalNemuber , String memberID){
        Member member = new Member(name , personalNemuber, memberID);
        members.add(member);
        return member;
    }

   /* public void saveOnVerboseList(Member member){
      //  registry = new Registry();
        registry.saveFile(member);
    }*/


    public Member deleteMember(Member member){
        this.member = member;
    //    registry = new Registry();
    //   this.members = registry.loadForVerboseList(registry.verboseList("VerboseList.txt"));
        this.members.remove(member);
        //I used here to return that member who was deleted
        return this.member;
>>>>>>> Stashed changes
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
