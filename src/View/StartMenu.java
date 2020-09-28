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
  //  public void welcomeMessage(MemberCreationMenu memberCreation , MemberMenu memberMenu, BoatMenu boatMenu){
    //    }


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



    private void showDeleteMenu(Member member,Boat boat) {
        member.deleteBoat(boat);
    }

    private void showUpdateBoatMenu(Member member,Boat boat) {
        System.out.println("");
    }

    private void askForABoatDataToRegister(Member member,Boat boat) {
        System.out.println("enter boat type:" +
                "\n0 for Sailboat , 1 for Motor sailor , 2 for Kayak/Canoe, 3 for Others");
        int typeValue = userIntInput();
        System.out.println("Enter length of the boat");
        int length = userIntInput();
        member.registerNewBoat(Boat.BoatType.values()[typeValue] , length);
    }

    private void showSpecificMemberData(BoatClub boatClub) {

    }


    public void showList(BoatClub boatClub){
        System.out.print("----- Show list of members -----\n"+
                " What kind of list, press 1 for compact list, press 2 for verbose list: ");
        int enter = sc.nextInt();

        if (enter==1){
            //showCompactList();
        }else if(enter==2){
            //showVerboseList();
        }else {
            //error
        }
    }


 /*switch (userInput) {
            case 1:
                createMemberMenu(boatClub);
                break;
            case 2:
                showCompactList(boatClub);
                break;
            case 3:
                showVerboseList(boatClub);
                break;
            case 4:
                boatClub.deleteMember(member);
                break;
            case 5:
                showUpdateMemberMenu(boatClub , member);
                break;
            case 6:
                showSpecificMemberData(boatClub);
                break;
            case 7:
                askForABoatDataToRegister(member,boat);
                break;
            case 8:
                showUpdateBoatMenu(member,boat);
                break;
            case 9:
                showDeleteMenu(member,boat);
                break;


        }*/

    }
