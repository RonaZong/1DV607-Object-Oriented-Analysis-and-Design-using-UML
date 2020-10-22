package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class MemberMenu {

    private Scanner sc = new Scanner(System.in);
    private BoatClub boatClub;
    private Member member;
    private boolean alreadyMember = false;


    public MemberMenu(BoatClub boatClub) {
        this.boatClub = boatClub;
    }

    public void showMemberMenu(){
        System.out.println("----Members' menu----\n" +
                "Press 1 to register as a member\n" +
                "Press 2 to update the information of a member\n" +
                "Press 3 to delete a member\n" +
                "Press 4 to see the information of a specific member\n" +
                "Press 5 to Boat Menu\n" +
                "Press 0 to quit\n");
        int userInput = sc.nextInt();
        actUponUserInputInMemberMenu(userInput, this.boatClub);
    }

    public void actUponUserInputInMemberMenu(int userInput, BoatClub boatClub) {
        switch (userInput) {
            case 1:
                createMemberMenu();
                break;
            case 2:
                showUpdateMemberMenu();
                break;
            case 3:
                boatClub.deleteMember(this.member);
                break;
            case 5:
                BoatMenu boatMenu = new BoatMenu(this.boatClub, this.member);
                boatMenu.showBoatMenu();
                break;
            case 0:
                System.exit(1);
        }
    }

    public void createMemberMenu(){
        System.out.println("----- Become a Member ----\n-" +
                "In order to be a member you have to enter following information : \n" +
                "Please enter user name: ");
        String name = sc.nextLine();

        System.out.print("Please enter personal number: ");
        String personalNumber = sc.nextLine();
        this.boatClub.creatMember(name, personalNumber);
        // this.alreadyMember = true;
    }

    private void showUpdateMemberMenu() {
        System.out.println("What do you want to update?");
        System.out.println("If you want to update name enter your new name otherwise press enter");
        String name = sc.nextLine();
        //do we need to check for validate personal number??
        //Yes

        System.out.println("If you want to update your personal number enter your new personal" +
                "number otherwise press enter");
        String personalNumber = sc.nextLine();
        this.boatClub.updateMemberInformation(this.member, name, personalNumber);
    }
}
