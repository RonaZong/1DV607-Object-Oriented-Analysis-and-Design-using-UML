package View;

import Model.Member;

import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private Member member;

    public Console() {
    }

    public void start(){

        System.out.println("Welcome to Boat Club\n" +
                "Press 1 to create a new member\n" +
                "Press 2 to show lists of all members\n" +
                "Press 3 to change a member’s information\n" +
                "Press 4 to check members information");



    }

    public void createMember(){
        String name = scanner.nextLine();
        String personalNumber = scanner.nextLine();
        String memberID = scanner.nextLine();

        if (this.member == null) {
            Member newMember = new Member(name, personalNumber, memberID);
        }
    }
}
