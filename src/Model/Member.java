package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private String name;
    private String personalNumber;
    private int memberID =1;
    //we need the know how many boats each member has
    //if member should have a boat at least so he or she can register we can initialize arraylist in method
    //otherwise we have to initialize arraylist here or we get null value
    private ArrayList<Boat> boats;
    
    // I think we don't need scanner here
   // private Scanner scanner = new Scanner(System.in);

    public Member(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
        creatUniqueID();
    }

    public Member(){

    }

   // sorry to comment this out I wrote a comment below and I will explain tomorrow
   /* public Member(String name, String personalNumber, int memberID) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberID = memberID;
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public int getMemberID() {
        return memberID;
    }

    //public void setMemberID(int memberID) {
      //  this.memberID = memberID;
    //}
    // I m not sure if it works or not but the member ID should be created by system and
    // we cant set it to whatever we want so I think we dont need setter
    public int creatUniqueID(){
        return memberID++;
    }

    public void addBoat(Boat boat){
        boats = new ArrayList<>();
        boats.add(boat);
    }

    public ArrayList<Boat> boatsOwnedByMember(){
        return this.boats;
    }
}
