package View;

import Model.Card;
import Model.BoatClub;
import Model.Dealer;

import java.util.Scanner;

public class BoatMenu {
    private Scanner sc = new Scanner(System.in);
    private BoatClub boatClub;
    private Dealer member;
    private Card boat;

    public BoatMenu(BoatClub boatClub, Dealer member) {
        this.boatClub = boatClub;
        this.member = member;
    }

    public void showBoatMenu(){
        System.out.println("----Boats' menu----\n" +
                "Press 1 to register a new boat\n" +
                "Press 2 to update a boat information\n" +
                "Press 3 to delete a boat\n" +
                "Press 0 to quit\n");
        int userInput = sc.nextInt();
        actUponUserInputInBoatMenu(userInput, this.member, this.boat);
    }

    public void actUponUserInputInBoatMenu(int userInput, Dealer member, Card boat) {
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
        this.member.registerBoat(Card.BoatType.values()[typeValue], length);
    }

    private void showUpdateBoatMenu() {
        System.out.println("");
    }
}

