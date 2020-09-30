package View;

import Model.BoatClub;
import Util.BoatType;

import java.util.Scanner;

public class MemberCreationMenu extends Menu {

    private Scanner sc;
    private String name;
    private String personalNumber;
    private int numberOfBoats;
    private float[] boatLength;
    private int typeOfBoat;
    private BoatType[] type;


    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }

    private int userIntInput(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private float userDoubleInput(){
        sc = new Scanner(System.in);
        return sc.nextFloat();
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
        System.out.println("Please enter numbers of boats:");
        this.numberOfBoats = userIntInput();
        boatLength = new float[numberOfBoats];
        type = new BoatType[numberOfBoats];
        for(int i = 0 ; i<numberOfBoats;i++){
            System.out.println("Please enter length of the boat:");
            boatLength[i] = userDoubleInput();
            System.out.println("Please enter boat type(1 for sailboat, 2 for motor sail, " +
                    "3 for kayak/canoe, and 4 for others)");
            type[i] = BoatType.values()[userIntInput()-1];
        }
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

    public void confirmationMsg(){
        System.out.println(this.name+" is added");
    }

    public int getNumberOfBoats(){
        return numberOfBoats;
    }

    public float[] getBoatLength() {
        return boatLength;
    }

    public BoatType[] getType() {
        return type;
    }
}
