package model;
import model.Boat.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Registry {
    private ArrayList<Member> memberList;
    private Database database;



    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public Registry() {
        memberList = new ArrayList<Member>();
    }

    public void reigstMember(String firstName, String secoundName, int memberID, int personlNumber) {
        this.memberList.add(new Member(memberID, firstName, secoundName, personlNumber));
    }
    public void reigstMember(String firstName, int memberID, int personlNumber) {
        this.memberList.add(new Member(firstName, ++memberID, personlNumber));
    }
    public void deletMamber(Member member) {
        this.memberList.remove(member);
    }
    public Member getMember(int memberID) {
        for (Member m : this.memberList) {
            if (m.getMemberID() == memberID)
                return m;
        }
        return null;
    }

    public void updateMamber(Member member,String firstName, String secoundName, int personlNumber) {
        member.setFirstName(firstName);
        member.setLastName(secoundName);
        member.setPersonalNumber(personlNumber);
    }
    public void addBoat(Member member,double len, boatType type) throws IllegalAccessException {
        member.registerBoat(len,type);
    }
    public void updateBoat(Member member,Boat boat,double len, boatType type) throws IllegalAccessException {
        member.updateBoat(len,type,boat);
    }
    public void deleteBoat(Member member,Boat boat){
        member.deleteBoat(boat);
    }

    public  void importData() throws IllegalAccessException, IOException {
        database=new Database();
        database.checkDataFiles();
        memberList=database.loadData();
    }

    public void saveData() throws IOException {
    database.saveData(memberList);
    }
}
