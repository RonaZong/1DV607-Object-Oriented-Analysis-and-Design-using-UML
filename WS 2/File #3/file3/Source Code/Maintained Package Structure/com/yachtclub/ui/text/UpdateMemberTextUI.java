package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UpdateMemberTextUI {
    private MemberManager memberManager;

    UpdateMemberTextUI(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int menuChoice = 0;
        int memberID = 0;

        if(!memberManager.hasMembers())
            System.out.println("\nPlease add members first!");

        while (!isDone) {
            System.out.println(memberManager.membersToString(false));
            System.out.print("\nPlease enter a MemberID to update or 0 (zero) to cancel: ");

            try {
                memberID = scanner.nextInt();
                if (memberID == 0)
                    return;
            } catch (InputMismatchException e) {
                continue;
            }

            if (memberManager.memberExists(memberID)) {
                isDone = true;
            }
            else
                System.out.println("\nCould not locate member with the MemberID provided.");
        }

        isDone = false; // Reset flag.
        scanner = new Scanner(System.in); // A precaution for some platforms.

        while (!isDone) {
            System.out.println("\nWhat would you like to update? ");
            System.out.print("1=update boat, 2=update member, 0=cancel: ");

            try {
                menuChoice = scanner.nextInt();
                if (menuChoice == 0)
                    return;
            } catch (InputMismatchException e) {
                continue;
            }

            switch(menuChoice) {
                case 1:
                    if(memberManager.hasBoats(memberID)) {
                        ChangeBoatTextUI changeBoatTextUI = new ChangeBoatTextUI(memberManager, memberID);
                        changeBoatTextUI.show();
                        isDone = true;
                    } else
                        System.out.println("\nFound no Boat. You can still update member information!");
                    break;
                case 2:
                    this.updateMember(memberID);
                    isDone = true;
                    break;
                case 0:
                    return;
            }
        }
    }

    private void updateMember(int memberID) {
        Pattern numberPattern = Pattern.compile("[0-9]{6}-[0-9]{4}"); // Validate personal number format.
        Pattern namePattern = Pattern.compile("[a-zA-Z'-.]+"); // Validate name format.
        Scanner scanner = new Scanner(System.in);
        String personalNumber = null;
        String memberName = null;
        boolean isDone = false;

        // Print selected memberID.
        System.out.println("\nSelected member:\n" + memberManager.memberToString(memberID));

        // Make sure that the formatting (not validation of logic) of the name is OK.
        while(!isDone) {
            System.out.print("\nUpdate member name (allowed characters: all letters, -, ', .): ");
            if (scanner.hasNext(namePattern)) {
                memberName = scanner.nextLine();
                isDone = true;
            } else {
                scanner.nextLine(); // Clean scanner from wrongly formatted name.
            }
        }

        isDone = false; // Make sure we reset flag for reuse.

        // Make sure the formatting (not validation of logic) of the personal number is OK.
        while (!isDone) {
            System.out.print("\nUpdate personal member (format: YYMMDD-NNNN): ");
            if (scanner.hasNext(numberPattern)) {
                personalNumber = scanner.nextLine();
                isDone = true;
            } else {
                scanner.nextLine(); // Clean scanner from wrongly formatted string.
            }
        }

        // Print to screen what the user updated.
        System.out.println("\nUpdated Member: ");
        System.out.println("Name: " + memberName);
        System.out.println("Personal number: " + personalNumber);

        // Update user.
        memberManager.updateMemberName(memberID, memberName);
        memberManager.updatePersonalNumber(memberID, personalNumber);
    }
}