package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private String name;
    private String personalNumber;
    private int numbersOfBoatsOwnByAMember;
    private String memberID ;//=1;
    private ArrayList<Boat> boats = new ArrayList<>();


    public Member(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberID = creatUniqueID();
    }

  /*  public Member(String name, String personalNumber, ArrayList<Boat> boats) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberID=creatUniqueID();
        this.boats = boats;
    }*/

    public Member(String name , String personalNumber,String uniqueID){
        setName(name);
        setPersonalNumber(personalNumber);
        setMemberID(uniqueID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //after updating information it should be saved
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
        //after updating information it should be saved
    }

    public String getMemberID() {
        return memberID;
    }

    private String creatUniqueID(){
        //use current time to creat a unique id
        //only take long from 8 to 12
        long ID = System.currentTimeMillis();
        return Long.toString(ID).substring(9,13);
    }

    public void setMemberID(String memberID){
        this.memberID=memberID;
    }

    public Iterable<Boat> boatsOwnedByMember(){
        return this.boats;
    }

   // public void setBoats(ArrayList<Boat> boats) {
     //   this.boats = boats;
    //}

    public void setNumbersOfBoatsOwnByAMember(int numbersOfBoats){
        this.numbersOfBoatsOwnByAMember=numbersOfBoats;
    }

    public int numberOfBoats(){
        return this.boats.size();
    }

    public int getNumbersOfBoatsOwnByAMember(){
          return this.boats.size();
    }

    public void registerNewBoat(Util.BoatType boatType, double length){
        Boat boat = new Boat(boatType, length);
        boats.add(boat);
    }

    public void deleteBoat(Boat boat) {
        boats.remove(boat);
    }
}
