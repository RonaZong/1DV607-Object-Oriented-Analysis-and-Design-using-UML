package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Member {
    private String name;
    private String personalNumber;
    private String password;
    private int memberID = 0;
    private ArrayList<Boat> boats;

    // I think we don't need scanner here
   // private Scanner scanner = new Scanner(System.in);
//    public Member(String personalNumber, String name) {
//        this.personalNumber = personalNumber;
//        this.name = name;
//        this.boats = new ArrayList<>();
//    }

    // Authentication
    public Member(String personalNumber, String name, String password, int memberID) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.password = password;
        this.memberID = memberID;
        this.boats = new ArrayList<>();
    }

    public void editMember(String personalNumber, String name, String password) {
        setPersonalNumber(personalNumber);
        setName(name);
        setPassword(password);
    }

    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
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


//    private int creatUniqueID(){
//        long ID = System.currentTimeMillis();
//        int memberID = Integer.parseInt(Long.toString(ID).substring(9,13));
//        return memberID;
//    }


    public ArrayList<Boat> boatsOwnedByMember(){
        return this.boats;
    }

    public void addBoat(Boat.BoatType boatType, double length){
        this.boats.add(new Boat(boatType, length));
    }

    public void updateBoat() {

    }

    public void deleteBoat(Boat boat) {
        boats.remove(boat);
    }


    public String toString(boolean compact) {
        String compactOrVerbose = "";

        if (compact) {   // Compact view.
            compactOrVerbose = ", Number of boats = " + boats.size();
        } else {        // Verbose view.
            for (int i = 0; i < boats.size(); i++) {
                compactOrVerbose += "\n\tBoat " + (i + 1) + ", " + boats.get(i).toString();
            }
        }
        return "MemberID: " + memberID +
                "\nName: " + name +
                compactOrVerbose;
    }
}
