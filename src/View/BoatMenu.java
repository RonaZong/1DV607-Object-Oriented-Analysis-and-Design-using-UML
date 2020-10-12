package View;

import Util.BoatType;
import Util.UserChoiceInBoatMenu;

import java.util.Scanner;

public class BoatMenu {
    private BoatType boatType;
    private double length;
//do we need to have min and max length for boat?

    private String userStringInput(){
        Scanner sc =new Scanner(System.in);
        return sc.nextLine();
    }

    public void showInstruction() {
        System.out.println("Press 1 to register a new boat\n"+
                "Press 2 to delete a boat\n"+
                "Press 3 to change the boat’s information");

    }

    public UserChoiceInBoatMenu getUserInputInBoatMenu(){
        UserChoiceInBoatMenu choice = null;
        String userInput=userStringInput();
        switch (userInput){
            case "1":
                choice = UserChoiceInBoatMenu.ADD_NEW_BOAT;
                break;
            case "2":
                choice = UserChoiceInBoatMenu.DELETE_BOAT;
                break;
            case "3":
                choice = UserChoiceInBoatMenu.CHANGE_BOAT_INFORMATION;
                break;
            default:
                choice = UserChoiceInBoatMenu.GO_BACK;
                break;
        }
        return choice;
    }

  /*  public String ShowAccessToMember(){
        System.out.print("For access the boat, pleas enter user name: ");
        memberName = userStringInput();
        return memberName;
    }*/

    public void showRegisterOrChangeABoat(){
        System.out.println("Enter boat type:" +
                "\n1 for Sailboat , 2 for Motor sailor , 3 for Kayak/Canoe, 4 for Others");
        boatType =  correctBoatType();
        System.out.println("Enter length of the boat");
        length = correctDouble();

    }

    public BoatType getBoatType(){
        return boatType;
    }

    public double getLength(){
        return length;
    }

    public void showAddConfirmation(){
        System.out.println(boatType+"is added");
    }

    private double correctDouble(){
        boolean isValid=false;
        double inputToDouble = 0;
        do{
            try{
                inputToDouble = Double.parseDouble(userStringInput());
                isValid = isValidDouble(inputToDouble);
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
        }while(!isValid);
        return inputToDouble;
    }

    private boolean isValidDouble(double input){
        if(input<=0 || input>70)
            throw new IllegalArgumentException("Boat length should be a valid number between 1-70");
        return true;
    }

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
}
