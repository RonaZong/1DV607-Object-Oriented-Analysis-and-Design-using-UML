package View;

import Model.Boat;
import Model.Member;

import java.util.Scanner;

public class BoatMenu extends Menu {

    private Scanner sc;



    @Override
    public void showInstruction() {

        System.out.println("enter your boat information");
    }

    private int userIntInput(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void askForABoatDataToRegister(Member member, Boat boat) {
        System.out.println("enter boat type:" +
                "\n0 for Sailboat , 1 for Motor sailor , 2 for Kayak/Canoe, 3 for Others");
        int typeValue = userIntInput();
        System.out.println("Enter length of the boat");
        int length = userIntInput();
        member.registerNewBoat(Util.BoatType.values()[typeValue] , length);
    }
}
