package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoatClub {
    private Map<Integer, Member> membersMap;
    private Member member;

    public BoatClub() {
        this.membersMap = new HashMap<>();
    }

    public Map<Integer, Member> getMembersMap() {
        return membersMap;
    }

    public void setMembersMap(Map<Integer, Member> membersMap) {
        this.membersMap = membersMap;
    }

    public void addMember(Member newMember){
        this.member = newMember;
        this.membersMap.put(this.member.getMemberID(), this.member);
    }

    // Update Member
    public void updateMember(int memberID, String personalNumber, String name, String password){
        membersMap.get(memberID).setPersonalNumber(personalNumber);
        membersMap.get(memberID).setName(name);
        membersMap.get(memberID).setPassword(password);
    }

    public void deleteMember(Member member){
//        this.members.remove(member);
        this.membersMap.remove(member.getMemberID());
    }

//    public ArrayList<Member> getAllMember(){
//        return this.members;
//    }

    public boolean memberExists(int memberID) {
        return this.membersMap.containsKey(memberID);
    }

    public String memberToString(int memberID) {
        if( (membersMap.size() > 0) && (memberID <= membersMap.size()) )
            return membersMap.get(memberID).toString();
        else
            return "\nNo member found. Please create new member.";
    }

    public List<String> save() {
        List<String> memberRegistry = new ArrayList<>();

        // Adding header information.
        memberRegistry.add(Integer.toString(this.member.getMemberID()));

        for (Map.Entry<Integer, Member> entry : membersMap.entrySet()) {
            memberRegistry.add( entry.getValue().getMemberID()+", "+
                    entry.getValue().getName()+", "+
                    entry.getValue().getPersonalNumber()+", ");
        }
        return memberRegistry;
    }

    public String membersToString(boolean compact) {
        String membersString = "";
        if (this.membersMap.size() > 0) {
            for (Map.Entry<Integer, Member> entry : this.membersMap.entrySet()) {
//                membersString += "\n" + (entry.getValue()).toString(compact);
            }
        } else {
            membersString = "\n No members found.";
        }
        return membersString;
    }

    public void polulate(List<String> memberRegistry) {
        // If nothing loaded ignore populating.
        if (memberRegistry == null) {
            return;
        }

        // Updating memberID counter.
        this.member.getMemberID() = Integer.parseInt(memberRegistry.remove(0));

        String[] parsedLine; // The parsed CSV temporary storage.

//        // Parse CSV string.
//        for (String textLine : memberRegistry) {
//            parsedLine = textLine.split(","); // Parse CSV.
//
//            // Parse the header for a member, name, id, personal number.
//            this.membersMap.put(Integer.parseInt(parsedLine[0]), new Member(parsedLine[1], parsedLine[2], Integer.parseInt(parsedLine[0])));
//
//            // Check if there are any boats associated to the member.
//            for (int i = 3; i < parsedLine.length - 1; i += 2)
//                this.member.addBoat(parsedLine[i], Integer.parseInt(parsedLine[i + 1]), Integer.parseInt(parsedLine[0]));
//        }

    }

}
