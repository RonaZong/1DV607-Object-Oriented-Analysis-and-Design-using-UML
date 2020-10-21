package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.MenuOptions;

import java.util.Scanner;

public class StartMenu {
    private Scanner sc = new Scanner(System.in);
    private MenuOptions menuOptions;

    public StartMenu() {
    }

    public void showInstruction(){
        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
                "Press 1 to member menu\n" +
                "Press 2 to show list\n" +
                "Press 3 to quit");
    }

    public int getInputInStartMenu() {
        int inputOfStartMenu = sc.nextInt();
        switch (inputOfStartMenu) {
            case 1:
                menuOptions = MenuOptions.MEMBER_MENU;
                if (menuOptions.getInput() == inputOfStartMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 2:
                menuOptions = MenuOptions.SHOW_LIST;
                if (menuOptions.getInput() == inputOfStartMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 0:
                menuOptions = MenuOptions.QUIT;
                if (menuOptions.getInput() == inputOfStartMenu) {
                    System.out.println(menuOptions.getMessage());
                }
        }
        return inputOfStartMenu;
    }

    private void showSpecificMemberData(BoatClub boatClub) {

    }

    public void showList(BoatClub boatClub){
        System.out.print("----- Show list of members -----\n"+
                " What kind of list, press 1 for compact list, press 2 for verbose list: ");
        int enter = sc.nextInt();

        if (enter==1){
            //showCompactList();
        }else if(enter==2){
            //showVerboseList();
        }else {
            //error
        }
    }



    public void showCompactList(BoatClub boatClub){
        for(Member member : boatClub.getAllMember()) {
            System.out.println("This member name is : " + member.getName() +
                    "\nwith memberID of : " + member.getMemberID() +
                    "\nwhich has " + member.boatsOwnedByMember().size() + "boats" +
                    "\n------------\n");
        }
    }

    public void showVerboseList(BoatClub boatClub){
        for(Member member : boatClub.getAllMember()){
            System.out.println("This member name is : " + member.getName() +
                           "\nwith personal number of " + member.getPersonalNumber() +
                            "\nwith memberID of " + member.getMemberID());
        //it might give a null exception
            System.out.println("This member has " + member.boatsOwnedByMember().size() + "boats");
            if(member.boatsOwnedByMember().size()> 0 ) {
                System.out.println("this member boat information is :");
                for (Boat boat : member.boatsOwnedByMember()) {
                    System.out.println("Boat type :" + boat.getType() +
                            "\nBoat color : " + boat.getLength());
                }
            }
        }
    }
}
