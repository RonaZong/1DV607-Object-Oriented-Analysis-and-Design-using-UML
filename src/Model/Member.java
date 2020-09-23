package Model;

import java.util.Scanner;

public class Member {
    private String name;
    private String personalNumber;
    private String memberID;
    private Boat boats;
    private Scanner scanner = new Scanner(System.in);

    public Member(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }

    public Member(String name, String personalNumber, String memberID) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberID = memberID;
    }

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

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void createMember(){
        String name = scanner.nextLine();
        String personalNumber = scanner.nextLine();
        String memberID = scanner.nextLine();
    }
}
