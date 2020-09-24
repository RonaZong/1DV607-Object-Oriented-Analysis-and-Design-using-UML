package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class StartMenu {
    Scanner sc = new Scanner(System.in);

    public StartMenu() {
    }

    public void start(BoatClub boatClub){


        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n"+
                "Press 1 to create a new member\n" +
                "Press 2 to show lists of all members\n" +
                //who can have access to a specific member's information?
                "press 3 to check member's information \n"+
                "press 4 to quit \n");
                // do we need to have an admin so can have access to member's information?


        int choice = sc.nextInt();
        switch(choice){
            case 1: createMemberMenu(boatClub);
            break;
            case 2: showList(boatClub);
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
        System.out.println("----- Add a Member -----");

        System.out.print("Please enter user name: ");
        String ch=sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Please enter personal number: ");
        String personalNumber = sc.next();
        boatClub.creatMember(name,personalNumber);


    }

    public void showCompactList(Model.Member member){
        System.out.println("This member name is : " + member.getName()+
                           "\nwith memberID of : " + member.getMemberID()+
                            "\nwhich has " + member.boatsOwnedByMember().size() + "boats");
    }

    public void showVerboseList(Model.Member member){
        System.out.println("This member name is : " + member.getName() +
                           "\nwith personal number of " + member.getPersonalNumber() +
                            "\nwith memberID of " + member.getMemberID());
        System.out.println("This member has " + member.boatsOwnedByMember().size() + "boats");
        if(member.boatsOwnedByMember().size()> 0 ){
            System.out.println("this member boat information is :");
            for(Boat boat : member.boatsOwnedByMember()){
                System.out.println("Boat type :" + boat.getType() +
                                   "\nBoat color : " + boat.getLength());
            }
        }
    }
}
