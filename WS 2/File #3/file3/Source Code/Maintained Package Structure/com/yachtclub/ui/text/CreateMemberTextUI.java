package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateMemberTextUI {
    private final MemberManager memberManager;

    CreateMemberTextUI(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public void show() {
        Pattern numberPattern = Pattern.compile("[0-9]{6}-[0-9]{4}"); // Validate personal number format.
        Pattern namePattern = Pattern.compile("[a-zA-Z'-.]+"); // Validate name format.
        Scanner scanner = new Scanner(System.in);
        String personalNumber = null;
        String memberName = null;
        boolean isDone = false;
        int menuChoice;
        int memberID;

        // Check if the user wants to create a boat if users already exist.
        while(!isDone) {
            System.out.println("\nWhat would you like to create? ");
            System.out.print("1=new member, 2=new boat, 0=cancel: ");
            try {
                menuChoice = scanner.nextInt();
                if (menuChoice == 0)
                    return;
            } catch (InputMismatchException e) {
                continue;
            }

            switch (menuChoice) {
                case 1:
                    this.createNewMember();
                    break;
                case 2:
                    if(memberManager.hasMembers())
                        this.delegateBoatAddition();
                    else
                        System.out.println("\nPlease create a member before adding a new Boat!");
                    break;
            }
        }
    }

    private void createNewMember() {
        Pattern numberPattern = Pattern.compile("[0-9]{6}-[0-9]{4}"); // Validate personal number format.
        Pattern namePattern = Pattern.compile("[a-zA-Z'-.]+"); // Validate name format.
        Scanner scanner = new Scanner(System.in);
        String personalNumber = null;
        String memberName = null;
        boolean isDone = false;
        int menuChoice;
        int memberID;

        // Make sure that the formatting (not validation of logic) of the name is OK.
        while(!isDone) {
            System.out.print("\nPlease enter a name (allowed characters: all letters, -, ', .): ");
            if( scanner.hasNext(namePattern) ) {
                memberName = scanner.nextLine();
                isDone = true;
            } else {
                scanner.nextLine(); // Clean scanner from wrongly formatted name.
            }
        }

        isDone = false; // Make sure we reset flag for reuse.
        scanner = new Scanner(System.in); // Some platforms behave differently, just a precaution.

        // Make sure the formatting (not validation of logic) of the personal number is OK.
        while(!isDone) {
            System.out.print("\nPlease enter a personal number (format: YYMMDD-NNNN): ");
            if( scanner.hasNext(numberPattern) ) {
                personalNumber = scanner.nextLine();
                isDone = true;
            } else {
                scanner.nextLine(); // Clean scanner from wrongly formatted name.
            }
        }

        // Create the member.
        memberID = memberManager.createMember(memberName, personalNumber);

        // Print to screen what the user added.
        System.out.println("\nAdded new Mmber: ");
        System.out.println("Name: "+memberName);
        System.out.println("Personal number: "+personalNumber);
        System.out.println("\nMember ID: "+memberID);

        scanner = new Scanner(System.in);
        isDone = false;

        // Check if user would like to add a boat to a new user.
        while (!isDone) {
            System.out.println("\nWould you like to add a Boat? Please enter a number. ");
            System.out.print("1=yes, 2=no: ");

            try {
                menuChoice = scanner.nextInt();
            } catch(InputMismatchException e) {
                continue;
            }

            switch (menuChoice) {
                case 1:
                    AddBoatTextUI addBoatTextUI = new AddBoatTextUI(memberManager, memberID);
                    addBoatTextUI.show();
                    isDone = true;
                    break;
                case 2:
                    return;
            }
        }
    }

    private void delegateBoatAddition() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int memberID;

        while(!isDone) {
            System.out.println("\nSelected member:\n" + memberManager.membersToString(false));
            System.out.print("\nPlease enter a Member ID to add boat to, or 0 (zero) to cancel: ");

            try {
                memberID = scanner.nextInt();
                if (memberID == 0)
                    return;
            } catch (InputMismatchException e) {
                continue;
            }

            if(memberManager.memberExists(memberID)) {
                System.out.println("\nSelected member:\n" + memberManager.membersToString(false));
                AddBoatTextUI addBoatTextUI = new AddBoatTextUI(memberManager, memberID);
                addBoatTextUI.show();
                isDone = true;
            }
            else {
                System.out.println("\nMember ID number not found!");
            }
        }
    }
}
