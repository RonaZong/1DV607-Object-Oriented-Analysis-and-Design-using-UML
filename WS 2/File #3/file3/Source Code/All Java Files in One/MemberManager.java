package com.yachtclub.domain.members;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberManager {
    private Map<Integer, Member> membersMap = new HashMap<>();
    private int nextMemberID;

    public MemberManager(){
        nextMemberID = 0;
    }

    public String memberToString(int memberID) {
        if( (membersMap.size() > 0) && (memberID <= membersMap.size()) )
            return membersMap.get(memberID).toStringExtended(false);
        else
            return "\nNo member found. Please create new member.";
    }

    public String membersToString(boolean compact) {
        String membersString = "";
        if( membersMap.size() > 0) {
            for (Map.Entry<Integer, Member> entry : membersMap.entrySet())
                membersString += "\n" + (entry.getValue()).toStringExtended(compact);
        } else
            membersString = "\nNo members found. Please create new members!";

        return membersString;
    }

    public boolean memberExists(int memberID) {
        return membersMap.containsKey(memberID);
    }

    // Create a member if everything is in order.
    public int createMember(String memberName, String personalNumber) {
        nextMemberID++; // Assign member an internal unique memberID done separately for clarity.
        membersMap.put(nextMemberID, new Member(memberName, personalNumber, nextMemberID)); // Adding member.
        return nextMemberID; // Returning member id.
    }

    public boolean deleteMember(int memberID) {
        return membersMap.remove(memberID) != null;
    }

    public boolean hasMembers() { return membersMap.size() > 0; }

    public boolean hasBoatNumber(int memberID, int boatNumber) {
        try {
            return membersMap.get(memberID).hasBoatNumber(memberID, boatNumber);
        } catch(NullPointerException e) {
            return false;
        }
    }

    public boolean hasBoats(int memberID) {
        try {
            return membersMap.get(memberID).hasBoats();
        } catch(NullPointerException e) {
            return false;
        }
    }

    public void addBoat(String boatType, int boatLength, int memberID) {
        membersMap.get(memberID).addBoat(boatType, boatLength);
    }

    public boolean delBoat(int memberID, int boatNumber) {
       return membersMap.get(memberID).delBoat(boatNumber);
    }

    // Update delegation methods.
    public void updateBoatType(int memberID, int boatNumber, String boatType) {
        membersMap.get(memberID).setBoatType(boatNumber, boatType);
    }
    public void updateBoatLength(int memberID, int boatNumber, int boatLength) {
        membersMap.get(memberID).setBoatLength(boatNumber, boatLength);
    }
    public void updateMemberName(int memberID, String updateName) {
        membersMap.get(memberID).setMemberName(updateName);
    }
    public void updatePersonalNumber(int memberID, String updatePersonalNumber) {
        membersMap.get(memberID).setPersonalNumber(updatePersonalNumber);
    }

    public List<String> forwardToPersistentStorage() {
        List<String> memberRegistry = new ArrayList<>();

        // Adding header information.
        memberRegistry.add(Integer.toString(nextMemberID));

        for (Map.Entry<Integer, Member> entry : membersMap.entrySet()) {
            memberRegistry.add( entry.getValue().getMemberID()+", "+
                    entry.getValue().getName()+", "+
                    entry.getValue().getPersonalNumber()+", "+
                    entry.getValue().getBoats());
        }
        return memberRegistry;
    }

    public void populateFromPersistentStorage(List<String> memberRegistry) {
        // If nothing loaded ignore populating.
        if(memberRegistry==null)
            return;

        // Updating memberID counter.
        nextMemberID = Integer.parseInt( memberRegistry.remove(0) );

        String[] parsedLine; // The parsed CSV temporary storage.

        // Parse CSV string.
        for(String textLine: memberRegistry) {
            parsedLine = textLine.split(","); // Parse CSV.

            // Parse the header for a member, name, id, personal number.
            membersMap.put(Integer.parseInt(parsedLine[0]), new Member( parsedLine[1], parsedLine[2],
                    Integer.parseInt(parsedLine[0])));

            // Check if there are any boats associated to the member.
            for(int i = 3; i < parsedLine.length-1; i+=2)
                this.addBoat(parsedLine[i], Integer.parseInt(parsedLine[i+1]), Integer.parseInt(parsedLine[0]));
        }
    }
}
