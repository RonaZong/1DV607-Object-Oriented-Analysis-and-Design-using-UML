package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private String name;
    private String personalNumber;

    //do we need to initialize?
    //change member id to string
    private String memberID ;//=1;
    //we need the know how many boats each member has
    //if member should have a boat at least so he or she can register we can initialize arraylist in method
    //otherwise we have to initialize arraylist here or we get null value
    private ArrayList<Boat> boats = new ArrayList<>();

    // I think we don't need scanner here
   // private Scanner scanner = new Scanner(System.in);

    public Member(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberID = creatUniqueID();
    }

    public void editMember(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
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

    public String getMemberID() {
        return memberID;
    }

    //public void setMemberID(int memberID) {
      //  this.memberID = memberID;
    //}
    // I m not sure if it works or not but the member ID should be created by system and
    // we cant set it to whatever we want so I think we dont need setter
    private String creatUniqueID(){
        //use current time to creat a unique id
        //only take long from 8 to 12
        long ID = System.currentTimeMillis();
        String memberID = Long.toString(ID).substring(9,13);
        return memberID;
    }

    public ArrayList<Boat> boatsOwnedByMember(){
        return this.boats;
    }

    public void registerBoat(Boat.BoatType boatType, double length){
        Boat boat = new Boat(boatType, length);
        boats.add(boat);
    }

    public void deleteBoat(Boat boat) {
        boats.remove(boat);
    }
}
