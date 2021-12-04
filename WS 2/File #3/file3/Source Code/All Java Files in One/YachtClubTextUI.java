package com.yachtclub.ui.text;
import com.yachtclub.domain.members.MemberManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class YachtClubTextUI {
    private MemberManager memberManager;

    public YachtClubTextUI(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int menuChoice;

        while (!isDone) {
            System.out.println("\nPlease pick a number below to process a Member. ");
            System.out.print("1=create, 2=retrieve, 3=update, 4=delete, 0=quit: ");

            try {
                menuChoice = scanner.nextInt();
            } catch(InputMismatchException e) {
                continue;
            }

            switch (menuChoice) {
                case 1:
                    CreateMemberTextUI createMemberTextUI = new CreateMemberTextUI(memberManager);
                    createMemberTextUI.show();
                    break;
                case 2:
                    RetrieveMemberTextUI retrieveMemberTextUI = new RetrieveMemberTextUI(memberManager);
                    retrieveMemberTextUI.show();
                    break;
                case 3:
                    UpdateMemberTextUI updateMemberTextUI = new UpdateMemberTextUI(memberManager);
                    updateMemberTextUI.show();
                    break;
                case 4:
                    DeleteMemberTextUI deleteMemberTextUI = new DeleteMemberTextUI(memberManager);
                    deleteMemberTextUI.show();
                    break;
                case 0:
                    return;
            }
        }
    }
}
