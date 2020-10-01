package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.UserChoiceInStartMenu;

import java.util.Scanner;

public class StartMenu extends Menu {
    private Scanner sc;
    private int userInput;
    private boolean alreadyMember=false;



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
                "Press 2 to go to member menu\n" +
                "Press 3 to go to boat menu\n" +
                "Press 4 to quit");


    }



    public UserChoiceInStartMenu getUserInputInStartMenu() {
        UserChoiceInStartMenu choice = null;

            this.userInput = userIntInput();
            switch (userInput) {
                case 1:
                    choice = UserChoiceInStartMenu.ADD_NEW_MEMBER;

                    break;
                case 2:
                    choice = UserChoiceInStartMenu.MEMBER_MENU;

                    break;
                case 3:
                    choice = UserChoiceInStartMenu.BOAT_MENU;
                    break;
                case 4:
                    choice = UserChoiceInStartMenu.QUIT;
                    break;

            }


        return choice;
    }

    }
