package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.MenuOptions;

import java.util.Scanner;

public class ShowList implements IView {
    private Scanner sc = new Scanner(System.in);
    private MenuOptions menuOptions;

    public ShowList() {
    }

    @Override
    public void showInstruction() {
        System.out.println("----Show List----\n" +
                "Press 1 to show COMPACT LIST\n" +
                "Press 2 to show VERBOSE LIST\n" +
                "Press 3 to show SPECIFIC MEMBER\n" +
                "Press 0 to back to previous menu");
        int userInput = sc.nextInt();
    }

    @Override
    public int getInput() {
        int inputOfShowListMenu = sc.nextInt();
        switch (inputOfShowListMenu) {
            case 1:
                menuOptions = MenuOptions.COMPACT_LIST;
                if (menuOptions.getInput() == inputOfShowListMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 2:
                menuOptions = MenuOptions.VERBOSE_LIST;
                if (menuOptions.getInput() == inputOfShowListMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 3:
                menuOptions = MenuOptions.SPECIFIC_MEMBER;
                if (menuOptions.getInput() == inputOfShowListMenu) {
                    System.out.println(menuOptions.getMessage());
                }
        }
        return inputOfShowListMenu;
    }


    public void showCompactList(BoatClub boatClub) {
        for (Member member : boatClub.getAllMember()) {
            System.out.println("This member name is : " + member.getName() +
                    "\nwith memberID of : " + member.getMemberID() +
                    "\nwhich has " + member.boatsOwnedByMember().size() + "boats" +
                    "\n------------\n");
        }
    }

    public void showVerboseList(BoatClub boatClub) {
        for (Member member : boatClub.getAllMember()) {
            System.out.println("This member name is : " + member.getName() +
                    "\nwith personal number of " + member.getPersonalNumber() +
                    "\nwith memberID of " + member.getMemberID());
            //it might give a null exception
            System.out.println("This member has " + member.boatsOwnedByMember().size() + "boats");
            if (member.boatsOwnedByMember().size() > 0) {
                System.out.println("this member boat information is :");
                for (Boat boat : member.boatsOwnedByMember()) {
                    System.out.println("Boat type :" + boat.getType() +
                            "\nBoat color : " + boat.getLength());
                }
            }
        }
    }
}

