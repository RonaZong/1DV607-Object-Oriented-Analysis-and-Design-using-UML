package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.MenuOptions;

import java.util.Scanner;

public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MenuOptions menuOptions;


    public MemberMenu() {
    }

    public void showInstruction(){
        System.out.println("----Members' menu----\n" +
                "Press 1 to add a member\n" +
                "Press 2 to update a member\n" +
                "Press 3 to delete a member\n" +
                "Press 0 to quit");
    }

    public int getInputInMemberMenu() {
        int inputOfMemberMenu = sc.nextInt();
        switch (inputOfMemberMenu) {
            case 1:
                menuOptions = MenuOptions.MEMBER_MENU;
                if (menuOptions.getInput() == inputOfMemberMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 2:
                menuOptions = MenuOptions.SHOW_LIST;
                if (menuOptions.getInput() == inputOfMemberMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 0:
                menuOptions = MenuOptions.QUIT;
                if (menuOptions.getInput() == inputOfMemberMenu) {
                    System.out.println(menuOptions.getMessage());
                }
        }
        return inputOfMemberMenu;
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
