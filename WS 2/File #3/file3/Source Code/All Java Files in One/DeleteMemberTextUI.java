package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteMemberTextUI {
    private MemberManager memberManager;

    DeleteMemberTextUI(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int menuChoice = 0;
        int memberID = 0;

        System.out.println(memberManager.membersToString(false));

        if(!memberManager.hasMembers())
            return;

        while(!isDone) {
            System.out.print("\nPlease enter a MemberID to process or 0 (zero) to cancel: ");

            try {
                memberID = scanner.nextInt();
                if(memberID == 0)
                    return;
            } catch (InputMismatchException e) {
                continue;
            }

            if(memberManager.memberExists(memberID))
                isDone = true;
            else
                System.out.println("\nCould not locate the MemberID.");
        }

        isDone = false; // Reset flag.

        // Prompt user what to delete.
        while(!isDone) {
            System.out.println(memberManager.membersToString(false));
            System.out.println("\nWould you like to delete a Boat or a Member? ");
            System.out.print("1=delete boat, 2=delete member 0=cancel: ");

            try {
                menuChoice = scanner.nextInt();
                if(menuChoice == 0)
                    return;
            } catch (InputMismatchException e) {
                continue;
            }

            switch(menuChoice){
                case 1:
                    if(memberManager.hasBoats(memberID)) {
                        DeleteBoatTextUI deleteBoatTextUI = new DeleteBoatTextUI(memberManager, memberID);
                        deleteBoatTextUI.show();
                    } else
                        System.out.println("\nSorry, no Boats found! You can still delete the member.");
                    break;
                case 2:
                    if(memberManager.hasMembers()) {
                        memberManager.deleteMember(memberID);
                        System.out.println("\nMember deleted successfully! ");
                    }
                    else {
                        System.out.println("\nSorry, no members found! Create a new member!");
                        isDone = true;
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
