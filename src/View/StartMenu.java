package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class StartMenu {
    private Scanner sc = new Scanner(System.in);
    private BoatClub boatClub;

    public StartMenu(BoatClub boatClub) {
        this.boatClub = boatClub;
    }

    public void welcomeMessage(){
        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
                "Press 1 to Member Menu\n" +
                "Press 2 to see a compact list of members\n"+
                "Press 3 to see a full detailed list of members\n"+
                "Press 4 to see the information of a specific member\n"+
                //who can have access to a specific member's information?
                // "press 3 to check member's information \n" +
                "Press 0 to quit \n");
                // do we need to have an admin so can have access to member's information?
        int userInput = sc.nextInt();

        actUponUserInputInMainMenu(userInput, boatClub);


           // showMemberMenu();
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

    public void actUponUserInputInMainMenu(int userInput, BoatClub boatClub) {
        switch (userInput) {
            case 1:
                MemberMenu memberMenu = new MemberMenu(boatClub);
                memberMenu.showMemberMenu();
                break;
            case 2:
                showCompactList(boatClub);
                break;
            case 3:
                showVerboseList(boatClub);
                break;
            case 4:
                showSpecificMemberData(boatClub);
                break;
            case 0:
                System.exit(1);
        }
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
