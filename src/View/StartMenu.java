package View;

import Model.BoatClub;

import java.util.Scanner;

public class StartMenu {
    Scanner sc = new Scanner(System.in);

    public StartMenu() {
    }

    public void start(BoatClub boatClub){


        System.out.println("Welcome to Boat Club\n" +
                "Press 1 to create a new member\n" +
                "Press 2 to show lists of all members\n" +
                //who can have access to a specific member's information?
                "press 3 to check member's information ");
                // do we need to have an admin so can have access to member's information?

        int choice = sc.nextInt();
        switch(choice){
            case 1: createMemberMenu(boatClub);
            break;
        }

    }

    public void createMemberMenu(BoatClub boatClub){
        System.out.println("--- Add a Member ---");

        System.out.print("Full name: ");
        String name = sc.next();
        System.out.print("Personal number: ");
        String personalNumber = sc.next();
        boatClub.creatMember(name,personalNumber);


    }
}
