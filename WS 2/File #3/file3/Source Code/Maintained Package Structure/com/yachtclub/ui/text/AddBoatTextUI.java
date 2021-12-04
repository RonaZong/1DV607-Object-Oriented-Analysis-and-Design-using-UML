package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddBoatTextUI {
    private MemberManager memberManager;
    private int memberID;

    AddBoatTextUI(MemberManager memberManager, int memberID) {
        this.memberManager = memberManager;
        this.memberID = memberID;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        String boatType = "";
        int boatLength = 0;
        int menuChoice;

        // If user wants to add a boat ask for further information.
        while (!isDone) {
            System.out.println("\nWhat type of boat would you like to add? Please enter a number. ");
            System.out.print("1=Sailboat, 2=Motorsailer, 3=Kayak/Canoe, 4=Other, 0=cancel: ");

            try {
                menuChoice = scanner.nextInt();
                isDone = true;
            } catch(InputMismatchException e) {
                continue;
            }

            switch (menuChoice) {
                case 1:
                    boatType = "Sailboat";
                    break;
                case 2:
                    boatType = "Motorsailer";
                    break;
                case 3:
                    boatType = "Kayak/Canoe";
                    break;
                case 4:
                    boatType = "Other";
                    break;
                case 0:
                    return;
            }
        }

        // Selection printed.
        System.out.println("You selected: "+boatType);

        isDone = false; // Reset the flag.
        scanner = new Scanner(System.in);

        // Ask for the boat length.
        while(!isDone) {
            System.out.print("\nPlease enter the length of the boat in centimeters (maximum: 40,000 cm): ");
            if( scanner.hasNextInt() ) {
                boatLength = scanner.nextInt();
                if(boatLength <= 40000)
                    isDone = true;
            } else {
                scanner.nextLine(); // Clean scanner from wrongly formatted name.
            }
        }

        // Selection printed.
        System.out.println("You specified: "+boatLength+" centimeters.");

        // Adding boat.
        memberManager.addBoat(boatType, boatLength, memberID);

        // Added a boat.
        System.out.println("\nAdded a Boat: ");
        System.out.println("Type: " + boatType);
        System.out.println("Length: " + boatLength);
    }
}
