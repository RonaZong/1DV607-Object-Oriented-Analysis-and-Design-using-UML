package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.BoatType;
import Util.UserChoiceInStartMenu;

import java.util.Scanner;

public class StartMenu extends Menu {
    private Scanner sc;
    private String userInput;
    private String name;
    private String personalNumber;
    private int numberOfBoats;
    private double[] boatLength;
    private BoatType[] type;


    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }

    private boolean IWantToQuit(){
        return userInput.equals("4");
    }

    @Override
    public void showInstruction() {

        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
                "Press 1 to add a new member\n" +
                "Press 2 to go to member menu\n" +
                "Press 3 to save\n" +
                "Press 4 to quit");
    }


    public UserChoiceInStartMenu getUserInputInStartMenu() {
        UserChoiceInStartMenu choice = null;

            this.userInput = userStringInput();
            switch (userInput) {
                case "1":
                    choice = UserChoiceInStartMenu.ADD_NEW_MEMBER;
                    break;
                case "2":
                    choice = UserChoiceInStartMenu.MEMBER_MENU;
                    break;
                case "3":
                    choice = UserChoiceInStartMenu.SAVE;
                    break;
                case "4":
                    choice = UserChoiceInStartMenu.QUIT;
                    break;
                default:
                    showError();

            }
        return choice;
    }

     private void showError(){
        System.out.println("You need to enter the correct number\n");
     }


    public void showInstructionOfCreateMember( ) {
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
        return input.length() == 1 && input.matches("-?\\d+(\\.\\d+)?");
        //check its digits
    }

    //check if correct integer used by user
    private int correctInteger(){
        boolean correctFormat=false;
        int inputToInteger = 0;
        do{
            try{
                inputToInteger = Integer.parseInt(userStringInput());
                correctFormat=true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
        }while(!correctFormat);
        return inputToInteger;
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

    public boolean userWantsToAddMoreMemebr() {

        String answer ="";
        do {
            System.out.println("Do you want to add another member\n" +
                    "Press \"yes\" to add a new member or \"no\" to go back to main menu");
            answer = userStringInput();
        }while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
        return answer.equalsIgnoreCase("yes");

    }

    public void showSaveMsg(){
        System.out.println("The information is saved");
    }

    }
