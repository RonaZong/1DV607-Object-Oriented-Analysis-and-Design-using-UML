package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.MenuOptions;

import java.util.Scanner;

public class BoatMenu implements IView{
    private Scanner sc = new Scanner(System.in);
    private Member member;
    private Boat boat;

    private MenuOptions menuOptions;

    public BoatMenu() {
    }

    @Override
    public void showInstruction(){
        System.out.println("----Boats' menu----\n" +
                "Press 1 to add a boat\n" +
                "Press 2 to update a boat\n" +
                "Press 3 to delete a boat\n" +
                "Press 0 to quit");
        int userInput = sc.nextInt();
        actUponUserInputInBoatMenu(userInput, this.member, this.boat);
    }

    @Override
    public int getInput() {
        int inputOfBoatMenu = sc.nextInt();
        switch (inputOfBoatMenu) {
            case 1:
                menuOptions = MenuOptions.ADD_BOAT;
                if (menuOptions.getInput() == inputOfBoatMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 2:
                menuOptions = MenuOptions.UPDATE_BOAT;
                if (menuOptions.getInput() == inputOfBoatMenu) {
                    System.out.println(menuOptions.getMessage());
                }
                break;
            case 3:
                menuOptions = MenuOptions.DELETE_BOAT;
                if (menuOptions.getInput() == inputOfBoatMenu) {
                    System.out.println(menuOptions.getMessage());
                }
        }
        return inputOfBoatMenu;
    }

    public void actUponUserInputInBoatMenu(int userInput, Member member, Boat boat) {
        switch (userInput) {
            case 1:
                askForABoatDataToRegister();
                break;
            case 2:
                showUpdateBoatMenu();
                break;
            case 3:
                this.member.deleteBoat(this.boat);
                break;
        }
    }

    private void askForABoatDataToRegister() {
        System.out.println("Enter boat type:" +
                "\n0 for Sailboat, 1 for Motor sailor , 2 for Kayak/Canoe, 3 for Others");
        int typeValue = sc.nextInt();
        System.out.println("Enter length of the boat");
        int length = sc.nextInt();
        this.member.addBoat(Boat.BoatType.values()[typeValue], length);
    }

    private void showUpdateBoatMenu() {
        System.out.println("");
    }
}

