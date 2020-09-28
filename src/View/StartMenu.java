package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class StartMenu extends Menu {
    private Scanner sc;
    private int userInput;
    private boolean alreadyMember=false;

    public enum UserChoiceInMainMenu{
        ADD_NEW_MEMBER, MEMBER_MENU, BOAT_MENU, QUIT
    }

    public StartMenu() {
    }

    private int userIntInput(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }
    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }

    private boolean IWantToQuit(){
        return userInput==4;
    }

    @Override
    public void showInstruction() {

        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
                "Press 1 to add a new member\n" +
                "Press 2 to go to member menu\n"+
                "Press 3 to go to boat menu\n"+
                "Press 4 to quit");
        // do we need to have an admin so can have access to member's information?
        this.userInput = userIntInput();

        getUserInputInMainMenu();
    }



    public UserChoiceInMainMenu getUserInputInMainMenu() {
        UserChoiceInMainMenu choice = null;
        switch (userInput) {
            case 1:
                choice = UserChoiceInMainMenu.ADD_NEW_MEMBER;
                break;
            case 2:
                choice = UserChoiceInMainMenu.MEMBER_MENU;
                break;
            case 3:
                choice = UserChoiceInMainMenu.BOAT_MENU;
                break;
            case 4:
                choice= UserChoiceInMainMenu.QUIT;
                break;

        }
        return choice;
    }

    }
