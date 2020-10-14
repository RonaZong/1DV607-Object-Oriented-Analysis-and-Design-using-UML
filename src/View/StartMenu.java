package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.BoatType;
import Util.UserChoiceInStartMenu;

import java.util.Scanner;

public class StartMenu {
  //  private Scanner sc;
    private String userInput;
    private String name;
    private String personalNumber;
    private int numberOfBoats;
    private double[] boatLength;
    private BoatType[] type;


    /** create member in the view, send it to controller, and controller send it to registry.
     * the validation "isValid" should be in the model */

    private String userStringInput(){
        Scanner sc =new Scanner(System.in);
        return sc.nextLine();
    }

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


    public Member showInstructionOfCreateMember( ) {
        Member member = null;
        do {
            System.out.println("----- Add a Member -----\n" +
                    "In order to add a member you have to enter following information : \n" +
                    "Please enter user name: ");
            this.name = userStringInput();
            System.out.print("Please enter personal number in 10 digits: ");
            this.personalNumber = userStringInput();
            try {
                    member = new Member(name, personalNumber);
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }while (member == null);
        return member;
    }

    public void userWantsToAddBoat(Member member){
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
            member.registerNewBoat(type[i], boatLength[i]);
        }
    }

//    private boolean isValid(String input){
//        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
//        //check its digits
//    }

    //check if correct integer used by user
    private int correctInteger(){
        boolean isValid=false;
         int inputToInteger=0;
        do{
            try{
                inputToInteger = Integer.parseInt(userStringInput());
               // positiveNumbersOfBoats(inputToInteger);
                isValid = isPositive(inputToInteger);
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }while(!isValid);
        return inputToInteger;
    }

    private boolean isPositive(int input){
        if(input<0)
            throw new IllegalArgumentException("Numbers of boats can't be a negative number");
        return true;
    }

    //check if correct double format used by user
    private double correctDouble(){
        boolean isValid =false;
        double inputToDouble = 0;
        do{
            try{
                inputToDouble = Double.parseDouble(userStringInput());
                isValid= isValidDouble(inputToDouble) ;
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }while(!isValid);
        return inputToDouble;
    }

    private boolean isValidDouble(double input){
        if(input<=0 || input>70)
            throw new IllegalArgumentException("Boat length should be a valid number between 1-70");
        return true;
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
