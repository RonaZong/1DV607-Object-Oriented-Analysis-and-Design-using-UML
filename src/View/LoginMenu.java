package View;

import Util.MenuOptions;

import java.util.Scanner;

public class LoginMenu implements IView{
    private Scanner sc = new Scanner(System.in);
    private MenuOptions menuOptions;


    public LoginMenu() {
    }

    @Override
    public void showInstruction(){

        System.out.println("----Login' menu----\n" +
                "Press 1 to MEMBER MENU\n" +
                "Press 2 to BOAT MENU\n" +
                "Press 0 to quit");
    }

    @Override
    public int getInput() {
        int inputOfLoginMenu = sc.nextInt();
        switch (inputOfLoginMenu) {
            case 1:
                menuOptions = MenuOptions.MEMBER_MENU;
                if (menuOptions.getInput() == inputOfLoginMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 2:
                menuOptions = MenuOptions.BOAT_MENU;
                if (menuOptions.getInput() == inputOfLoginMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 0:
                menuOptions = MenuOptions.QUIT;
                if (menuOptions.getInput() == inputOfLoginMenu) {
                    System.out.println(menuOptions.getMessage());
                }
        }
        return inputOfLoginMenu;
    }


}
