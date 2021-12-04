package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeBoatTextUI {
    private MemberManager memberManager;
    private int memberID;

    ChangeBoatTextUI(MemberManager memberManager, int memberID) {
        this.memberManager = memberManager;
        this.memberID = memberID;
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int menuChoice;

        while (memberManager.hasBoats(memberID)) {
            System.out.println("\n"+memberManager.memberToString(memberID));
            System.out.print("\nPlease enter the BOAT number to update or 0 (zero) to cancel:  ");

            try {
                menuChoice = scanner.nextInt();
                if(menuChoice == 0)
                    return;
            } catch(InputMismatchException e) {
                continue;
            }

            if(memberManager.hasBoatNumber(memberID, menuChoice)) {
                if (this.updateBoat(menuChoice))
                    System.out.println("\nBoat updated successfully!");
                else
                    System.out.println("\nBoat updated cancelled!");
            } else {
                System.out.println("\nCould not find a BOAT with that number. Please try again.");
            }
        }
    }

    private boolean updateBoat(int boatNumber) {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        String boatType = "";
        int boatLength = 0;
        int menuChoice;

        // If user wants to add a boat ask for further information.
        while (!isDone) {
            System.out.println("\nUpdate BOAT type: ");
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
                    return false;
            }
        }

        // Selection printed.
        System.out.println("You selected: "+boatType);

        isDone = false; // Reset the flag.

        // Ask for the boat length.
        while(!isDone) {
            System.out.print("\nUpdate length of boat in centimeters (max: 40,000 cm): ");
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

        // Print to screen what the user updated.
        System.out.println("\nUpdated Boat: ");
        System.out.println("Type: " + boatType);
        System.out.println("Length: " + boatLength);

        // Update boat.
        memberManager.updateBoatType(memberID, boatNumber, boatType);
        memberManager.updateBoatLength(memberID, boatNumber, boatLength);

        return true; // Successfully update.
    }
}
