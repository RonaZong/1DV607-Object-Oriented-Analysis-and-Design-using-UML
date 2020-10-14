package Model;

import java.util.ArrayList;
import java.util.IllegalFormatWidthException;
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
    private int numbersOfBoatsOwnByAMember;
    private String memberID ;

    private ArrayList<Boat> boats = new ArrayList<>();


    public Member(String name, String personalNumber) {
        setName(name);
        setPersonalNumber(personalNumber);
        this.memberID = creatUniqueID();
    }

    public void editMember(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;

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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPersonalNumber() { return personalNumber; }

    public void setPersonalNumber(String personalNumber) {
        if(!isValid(personalNumber)) {
            throw new IllegalArgumentException("Personal number should be a 10 digit number\n");
        }
        this.personalNumber = personalNumber;
    }

    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
        //check its digits
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

    public ArrayList<Boat> boatsOwnedByMember(){
        return this.boats;
    }

    public void registerANewBoat(Boat boat){

    public void setMemberID(String memberID){ this.memberID=memberID; }

    public Iterable<Boat> boatsOwnedByMember(){ return this.boats; }

   // public void setBoats(ArrayList<Boat> boats) {
     //   this.boats = boats;
    //}

    public void setNumbersOfBoatsOwnByAMember(int numbersOfBoats){
        this.numbersOfBoatsOwnByAMember=numbersOfBoats;
    }

    public int numberOfBoats(){
        return this.boats.size();
    }

    public void registerNewBoat(Util.BoatType boatType, double length){
        Boat boat = new Boat(boatType, length);
        boats.add(boat);
    }

    public void deleteBoat(Boat boat) {
        if(boats.isEmpty())
            throw new IllegalArgumentException("list is empty");
        boats.remove(boat);
    }
}
