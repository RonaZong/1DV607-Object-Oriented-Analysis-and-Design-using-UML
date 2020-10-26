package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.MenuOptions;

import java.util.Scanner;

public class StartMenu implements IView{
    private Scanner sc = new Scanner(System.in);
    private MenuOptions menuOptions;

    public StartMenu() {
    }

    @Override
    public void showInstruction(){
        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
                "Press 1 to log in\n" +
                "Press 2 to show list\n" +
                "Press 3 to quit");
    }

    @Override
    public int getInput() {
        int inputOfStartMenu = sc.nextInt();
        switch (inputOfStartMenu) {
            case 1:
                menuOptions = MenuOptions.LOG_IN;
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

    public boolean loginAuthentication(Member member) {
        System.out.print("Enter your username: ");
        String name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        return member.getName().equals(name) && member.getPassword().equals(password);
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




}
