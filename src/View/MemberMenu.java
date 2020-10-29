package View;

import Model.Member;
import Util.MenuOptions;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MemberMenu implements IView{
    private Scanner sc = new Scanner(System.in);
    private MenuOptions menuOptions;
    private Pattern personalNumberPattern = Pattern.compile("[1]{1}-[9]{1}-[0-9]{2}-[0-12]{2}-[0-31]{2}-[0-9]{4}");
    private String personalNumber;
    private String name;
    private String password;
    private int memberID = 0;

    public MemberMenu() {
    }

    @Override
    public void showInstruction(){
        System.out.println("----Members' menu----\n" +
                "Press 1 to add a member\n" +
                "Press 2 to update a member\n" +
                "Press 3 to delete a member\n" +
                "Press 0 to quit");
    }

    @Override
    public int getInput() {
        int inputOfMemberMenu = sc.nextInt();
        switch (inputOfMemberMenu) {
            case 1:
                menuOptions = MenuOptions.ADD_MEMBER;
                if (menuOptions.getInput() == inputOfMemberMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 2:
                menuOptions = MenuOptions.UPDATE_MEMBER;
                if (menuOptions.getInput() == inputOfMemberMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 3:
                menuOptions = MenuOptions.DELETE_MEMBER;
                if (menuOptions.getInput() == inputOfMemberMenu) {
                    System.out.println(menuOptions.getMessage());
                }
        }
        return inputOfMemberMenu;
    }


    public Member addMember(){
        System.out.println("----- Add a Member ----\n-" +
                "In order to be a member you have to enter following information: \n" +
                "Please enter personal number: ");

        while(!sc.hasNext(personalNumberPattern)) {
            sc.nextLine();
            personalNumber = sc.nextLine();
        }

        System.out.println("Please enter user name: ");
        String name = sc.nextLine();

        System.out.println("Please enter password: ");
        String password = sc.nextLine();

        memberID++;
        Member newMember = new Member(personalNumber, name, password, memberID);

        return newMember;
    }

    public void updateMember(Member member) {
        String YN = null;
        String personalNumber = member.getPersonalNumber();
        String name = member.getName();
        String password = member.getPassword();

        System.out.println("Update personalNumber? (Y / N)");
        if (YN.equals('Y')) {
            personalNumber = sc.nextLine();
        }
        
        System.out.println("Update name? (Y / N)");
        YN = sc.nextLine();
        if (YN.equals('Y')) {
            name = sc.nextLine();
        }

        System.out.println("Update password? (Y / N)");
        YN = sc.nextLine();
        if (YN.equals('Y')) {
            password = sc.nextLine();
        }
        
        member.editMember(personalNumber, name, password);
    }
}
