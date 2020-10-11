package View;

import Model.BoatClub;
import Util.BoatType;

import java.util.Scanner;

public class MemberCreationMenu extends Menu {

    private Scanner sc;
    private String name;
    private String personalNumber;
    private int numberOfBoats;
    private double[] boatLength;
    private BoatType[] type;


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
        System.out.println("Please enter numbers of boats:");
        this.numberOfBoats = correctInteger();
        boatLength = new double[numberOfBoats];
        type = new BoatType[numberOfBoats];
        for(int i = 0 ; i<numberOfBoats;i++){
            System.out.println("Please enter length of the boat " + (i+1)+ ":");
            boatLength[i] = correctDouble();
            System.out.println("Please enter boat type(1 for sailboat, 2 for motor sail, " +
                    "3 for kayak/canoe, and 4 for others)");
            type[i] = correctBoatType();
        }
    }

    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
        //check its digits
    }

    //check if correct integer used by user
    private int correctInteger(){
        boolean correctFormat=false;
        int inputToDouble = 0;
        do{
            try{
                inputToDouble = Integer.parseInt(userStringInput());
                correctFormat=true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
        }while(!correctFormat);
        return inputToDouble;
    }

    //check if correct double format used by user
    private double correctDouble(){
        boolean correctFormat=false;
        double inputToDouble = 0;
        do{
        try{
           inputToDouble = Double.parseDouble(userStringInput());
            correctFormat=true;
        }catch (NumberFormatException ex){
          System.out.println("Enter a correct number");
        }
        }while(!correctFormat);
        return inputToDouble;
    }

    //check if userinput is correct in boat type
    private BoatType correctBoatType(){
        boolean correctFormat=false;
        BoatType input = null ;
        do{
            try{
                input = BoatType.values()[Integer.parseInt(userStringInput())-1];
                correctFormat=true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a number");
            }catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("You have to choose between 1 to 4");
            }
        }while(!correctFormat);
        return input;

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

    public double[] getBoatLength() {
        return boatLength;
    }

    public BoatType[] getType() {
        return type;
    }
}
