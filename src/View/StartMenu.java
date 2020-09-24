package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class StartMenu {
    private Scanner sc;
    private int userInput;
    private boolean alreadyMember;

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

    public void welcomeMessage(BoatClub boatClub){

        while (!IWantToQuit()) {
            System.out.println("Welcome to Boat Club\n" +
                    "-----------------------\n" +
                    "If you are not a member press 1 to register as a new member\n" +
                    "Otherwise press 2 to show members' menu\n" +
                    //who can have access to a specific member's information?
                   // "press 3 to check member's information \n" +
                    "press 4 to quit \n");
            // do we need to have an admin so can have access to member's information?

            userInput = userIntInput();

            actUponUserInput(userInput , boatClub);
           /* int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createMemberMenu(boatClub);
                    break;
                case 2:
                    showList(boatClub);
                    break;

            }*/
        }
    }

    public void showMemberMenu(){
        System.out.println("----Members' menu----");
        System.out.println("For see a compact list of members press 5 ");
        System.out.println("For see a full detailed list of members press 6");
        System.out.println("For see a full detailed list of members press 6");
        System.out.println("For see a full detailed list of members press 6");
    }

    public void actUponUserInput(int userInput , BoatClub boatClub) {
        switch (userInput) {
            case 1:
                createMemberMenu(boatClub);
                break;
            case 2:
                showList(boatClub);
                break;
        }
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

    public void createMemberMenu(BoatClub boatClub){
        System.out.println("----- Become a Member -----");

        System.out.println("In order to be a member you have to enter following information : ");
        System.out.print("Please enter user name: ");
        //String ch=sc.nextLine();????
        String name = userStringInput();
        System.out.print("Please enter personal number: ");
        String personalNumber = userStringInput();
        boatClub.creatMember(name,personalNumber);


    }

    public void showCompactList(BoatClub boatClub){
        for(Member member : boatClub.getAllMember()) {
            System.out.println("This member name is : " + member.getName() +
                    "\nwith memberID of : " + member.getMemberID() +
                    "\nwhich has " + member.boatsOwnedByMember().size() + "boats" +
                    "\n------------\n");
        }
    }

    public void showVerboseList(BoatClub boatClub){
        for(Member member : boatClub.getAllMember()){
        System.out.println("This member name is : " + member.getName() +
                           "\nwith personal number of " + member.getPersonalNumber() +
                            "\nwith memberID of " + member.getMemberID());
        //it might give a null exception
        System.out.println("This member has " + member.boatsOwnedByMember().size() + "boats");
        if(member.boatsOwnedByMember().size()> 0 ) {
            System.out.println("this member boat information is :");
            for (Boat boat : member.boatsOwnedByMember()) {
                System.out.println("Boat type :" + boat.getType() +
                        "\nBoat color : " + boat.getLength());
            }
        }
        }
    }


    }
