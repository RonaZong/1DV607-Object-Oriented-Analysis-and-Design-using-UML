package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RetrieveMemberTextUI {
    private MemberManager memberManager;

    RetrieveMemberTextUI(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int menuChoice;

        while (!isDone) {
            System.out.println("\nHow do you prefer to retrieve member(s)? ");
            System.out.print("1=list compact, 2=list verbose, 0=cancel: ");

            try {
                menuChoice = scanner.nextInt();
            } catch(InputMismatchException e) {
                continue;
            }

            switch (menuChoice) {
                case 1:
                    System.out.println(memberManager.membersToString(true)); // True = compact list.
                    isDone = true;
                    break;
                case 2:
                    System.out.println(memberManager.membersToString(false)); // False = verbose list.
                    isDone = true;
                    break;
                case 0:
                    return;
            }
        }

    }
}
