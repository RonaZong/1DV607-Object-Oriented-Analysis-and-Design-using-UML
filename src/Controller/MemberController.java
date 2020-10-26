package Controller;

import Model.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberController {
    private Map<Integer, Member> memberMap = new HashMap<>();
    private int memberID;

    public MemberController() {
        this.memberID = 0;
    }

    public String memberToString(int memberID) {
        if ((memberMap.size() > 0) && (memberID <= memberMap.size())) {
//            return memberMap.get(memberID).toString(false);
        }
        else {
            return "\nNo member is founded.";
        }
    }

    public String membersToString(boolean compact) {
        String membersString = "";
        if (memberMap.size() > 0) {
            for (Map.Entry<Integer, Member> entry : memberMap.entrySet()) {
//                membersString += "\n" + (entry.getValue()).toString(compact);
            }
        } else {
            membersString = "\n No members found.";
        }
        return membersString;
    }

    public boolean memberExists(int memberID) {
        return memberMap.containsKey(memberID);
    }

    public int createMember(String personalNumber, String name, String password) {
        this.memberID ++;
        this.memberMap.put(memberID, new Member(personalNumber, name, password));
        return memberID;
    }
}
