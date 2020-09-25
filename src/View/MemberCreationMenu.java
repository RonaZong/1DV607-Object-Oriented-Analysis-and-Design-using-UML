package View;

import Model.BoatClub;

import java.util.Scanner;

public class MemberCreationMenu extends Menu {

    private Scanner sc;
    private String name;
    private String personalNumber;

    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }

    public void showMenuForRegister() {
        System.out.println("----- Add a Member -----\n" +
                "In order to add a member you have to enter following information : \n"+
                "Please enter user name: ");
        this.name = userStringInput();
        do {
            System.out.print("Please enter personal number in 10 digits: ");
            this.personalNumber = userStringInput();
        }while (!isValid(personalNumber));


    }

    private void createMember(BoatClub boatClub){
        boatClub.creatMember(name , personalNumber);
    }

    private boolean isValid(String input){
        return input.length()==10;
    }

    @Override
    public void showInstruction( Menu menu) {

    }
}
