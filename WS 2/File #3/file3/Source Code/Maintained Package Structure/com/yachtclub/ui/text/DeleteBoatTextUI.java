package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteBoatTextUI {
    private MemberManager memberManager;
    private int memberID;

    DeleteBoatTextUI(MemberManager memberManager, int memberID) {
        this.memberManager = memberManager;
        this.memberID = memberID;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int menuChoice;

        while (memberManager.hasBoats(memberID)) {
            System.out.println(memberManager.memberToString(memberID));
            System.out.print("\nPlease enter the Boat number for deletion or 0 (zero) to cancel:  ");

            try {
                menuChoice = scanner.nextInt();
                if(menuChoice == 0)
                    return;
            } catch(InputMismatchException e) {
                continue;
            }

            if( memberManager.delBoat(memberID, menuChoice) )
                System.out.println("\nBoat deleted successfully!");
            else
                System.out.println("\nCould not find a Boat with that number. Please try again.");
        }
    }
}
