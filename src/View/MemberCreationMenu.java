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

    @Override
    public void showInstruction( ) {
        System.out.println("----- Add a Member -----\n" +
                "In order to add a member you have to enter following information : \n"+
                "Please enter user name: ");
        this.name = userStringInput();
        do {
            System.out.print("Please enter personal number in 10 digits: ");
            this.personalNumber = userStringInput();
        }while (!isValid(personalNumber));
    }

    private boolean isValid(String input){
        return input.length()==10;
    }

    public String getName(){
        return this.name;
    }

    public String getPersonalNumber(){
        return  this.personalNumber;
    }
}
