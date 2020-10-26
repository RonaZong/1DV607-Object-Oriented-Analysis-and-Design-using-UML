package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Member {
    private String name;
    private String personalNumber;
    private String password;

    //do we need to initialize?
    //change member id to string
    private int memberID ;//=1;
    //we need the know how many boats each member has
    //if member should have a boat at least so he or she can register we can initialize arraylist in method
    //otherwise we have to initialize arraylist here or we get null value
    private ArrayList<Boat> boats;

    // I think we don't need scanner here
   // private Scanner scanner = new Scanner(System.in);
    public Member(String personalNumber, String name) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.memberID = creatUniqueID();
        this.boats = new ArrayList<>();
    }

    // Authentication
    public Member(String personalNumber, String name, String password) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.password = password;
        this.memberID = creatUniqueID();
        this.boats = new ArrayList<>();
    }

    public void editMember(String personalNumber, String name, String password) {
        setPersonalNumber(personalNumber);
        setName(name);
        setPassword(password);
    }

    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
        //check its digits
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    // I m not sure if it works or not but the member ID should be created by system and
    // we cant set it to whatever we want so I think we dont need setter
    private int creatUniqueID(){
        //use current time to creat a unique id
        //only take long from 8 to 12
        long ID = System.currentTimeMillis();
        int memberID = Integer.parseInt(Long.toString(ID).substring(9,13));
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
