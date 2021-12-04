package com.yachtclub.domain.members;
import com.yachtclub.domain.boats.Boat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Member {
    private List<Boat> membersBoats;
    private String personalNumber;
    private String name;
    private int memberID; // Internal unique ID.
    private UUID memberUUID; // The unique ID, external.

    Member(String name, String personalNumber, int memberID) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberID = memberID;
        membersBoats = new ArrayList<>();
        memberUUID = UUID.randomUUID();
    }

    public String toStringExtended(boolean compact) {
        String compactOrVerbose = "";

        if (compact) {   // Compact view.
            compactOrVerbose = ", Number of boats = " + membersBoats.size();
        } else {        // Verbose view.
            for (int i = 0; i < membersBoats.size(); i++) {
                compactOrVerbose += "\n\tBoat " + (i + 1) + ", " + membersBoats.get(i).toString();
            }
        }
        return "MemberID = " + memberID +
                ", Name = " + name +
                ", Personal Number = " + personalNumber +
                compactOrVerbose;
    }

    public boolean hasBoats() {
        return membersBoats.size() > 0;
    }

    public boolean hasBoatNumber(int memberID, int boatNumber) {
        return (boatNumber > 0) && (boatNumber <= membersBoats.size());
    }

    public void addBoat(String boatType, int boatLength) {
        membersBoats.add(new Boat(boatType, boatLength));
    }

    public boolean delBoat(int boatNumber) {
        if ((boatNumber > 0) && (boatNumber <= membersBoats.size()))
            return membersBoats.remove(boatNumber - 1) != null;
        else
            return false;
    }


    // Setter methods.
    public void setBoatType(int boatNumber, String boatType) {
        membersBoats.get(boatNumber - 1).setType(boatType);
    }

    public void setBoatLength(int boatNumber, int boatLength) {
        membersBoats.get(boatNumber - 1).setLength(boatLength);
    }

    public void setMemberName(String updateName) {
        this.name = updateName;
    }

    public void setPersonalNumber(String updatePersonalNumber) {
        this.personalNumber = updatePersonalNumber;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getBoats() {
        String boats = "";
        for(Boat boat : membersBoats) {
            boats += boat.getType()+","+boat.getLength()+",";
        }
        return boats;
    }
}
