package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.BoatType;
import Util.UserChoiceInBoatMenu;
import Util.UserChoiceInMemberMenu;

import java.util.Scanner;

public class MemberMenu {
    private String userInput;
   // private Scanner sc;
    private String name;
    private String personalNumber;
    private BoatType boatType;
    private double length;

    private String userStringInput(){
        Scanner sc =new Scanner(System.in);
        return sc.nextLine();
    }


    public void showInstruction() {
        System.out.println("Press 1 to show a compact list of members\n" +
                           "Press 2 to show a verbose list of members\n" +
                            "Press any key to go back to main menu");

      //  userInput = userStringInput();
    }

    public UserChoiceInMemberMenu getUserInputInMemberMenu() {
        UserChoiceInMemberMenu choice = null;
        String input = userStringInput();
        switch (input) {
            case "1":
                choice = UserChoiceInMemberMenu.COMPACT_LIST;
                break;
            case "2":
                choice = UserChoiceInMemberMenu.VERBOSE_LIST;
                break;
            default:
                choice = UserChoiceInMemberMenu.QUIT;
                break;

        }
        return choice;
    }

    public UserChoiceInMemberMenu getInputInCompactList() {
        UserChoiceInMemberMenu choice = null;

        switch(userInput){
            case "1":
                choice = UserChoiceInMemberMenu.DELETE;
                break;
            case "2":
                choice = UserChoiceInMemberMenu.UPDATE;
                break;
            case "3":
                choice = UserChoiceInMemberMenu.SPECIFIC_MEMBER;
                break;
            default:
                choice = UserChoiceInMemberMenu.QUIT;
                break;
        }
        return choice;
    }

    public Member showCompactList(BoatClub boatClub){
        int index =1;
        try {
            for (Member member : boatClub.getAllMembersLocally()) {
                System.out.println((index++) + ":This member name is : " + member.getName() +
                        "\nwith memberID of : " + member.getMemberID() +
                        "\nwhich has " + member.numberOfBoats() + "boat(s)" +
                        "\n------------\n");
            }

            System.out.println("Enter index of member to choose:\n" +
                    "Or press other integer to go back");
            int chosenMember = correctInteger();
            index = 1;
            for (Member member : boatClub.getAllMembersLocally()) {
                if (index == chosenMember) {
                    System.out.println("Press 1 to delete a member\n" +
                            "Press 2 to update a member information\n" +
                            "Press 3 to see a specific member data\n" +
                            "Press any other key to go back");

                    userInput = userStringInput();
                    return member;
                } else {
                    index++;
                }
            }

        System.out.println("This member does not exist you will go back to last menu\n");
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        userInput="";//to not get null error in line 59 in getInputInCompactList()
        return null;
    }

    public void showVerboseList(BoatClub boatClub){
        try {// if list is empty
            for(Member member : boatClub.getAllMembersLocally()){
                System.out.println("------------------------");
                showMemberInformation(member);
                System.out.println("\n----------------------\n\n");
            }
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    public void showUpdateMenu(){
       // System.out.println("What do you want to update?");
        System.out.println("Enter new name");
        name = userStringInput();
        do {
            System.out.println("Enter your new personal 10 digits");
            personalNumber = userStringInput();
        }while (!isValid(personalNumber));
    }

    public void showConfirmationMsg(Member member){
        System.out.println(member.getName() + " is deleted");

    }

    public void showUpdateConfirmationMsg(Member member){
        System.out.println(member.getName() + " is updated");
    }

    public void showMemberInformation(Member member) {
        System.out.println("This member name is : " + member.getName() +
                "\nwith personal number of " + member.getPersonalNumber() +
                "\nwith memberID of " + member.getMemberID());
        //it might give a null exception
        System.out.println("This member has " + member.numberOfBoats() + "boats");
        int index=1;
        System.out.println("this member boat information is :");
        for (Boat boat : member.boatsOwnedByMember()) {
            System.out.println((index++) + " - Boat type :" + boat.getType() +
                    ", Boat Length : " + boat.getLength());
        }

    }

    /*public Boat askUserForChooseAnOptionInBoatMenu(Member member){
        if(member.numberOfBoats()==0){
            System.out.println("Press 1 to register a new boat\n" +
                    "Or press any key to continue");
            userInput = userStringInput();
            if(!userInput.equalsIgnoreCase("1"))
            System.out.println("Enter index of boat to choose or any other key to go back to last menu:");
        String chosenMember = userStringInput();
        int index = 1;
        for(Boat boat : member.boatsOwnedByMember()) {
            if (index == Integer.parseInt(chosenMember)) {
                System.out.println("Press 2 to update the boat information\n" +
                                   "Press 3 to delete the boat");
                userInput = userStringInput();
                return boat;
            } else {
                index++;
            }
        }
        }else{
            System.out.println("Press 1 to register a new boat");
            userInput = userStringInput();
        }
        return null;
    }*/

    public boolean askUserForChooseAnOptionInBoatMenu(Member member){

        if(member.numberOfBoats()==0) {
            System.out.println("Press 1 to register a new boat\n" +
                    "Or press any key to continue");
            userInput = userStringInput();
            if (!userInput.equalsIgnoreCase("1"))
                return true;
        }
        // System.out.println("Enter index of boat to choose or any other key to go back to last menu:");
        //  String chosenMember = userStringInput();
        // int index = 1;
        //for(Boat boat : member.boatsOwnedByMember()) {
        //   if (index == Integer.parseInt(chosenMember)) {
        else {
            System.out.println("Press 1 to register a bew boat\n" +
                    "Press 2 to update the boat information\n" +
                    "Press 3 to delete the boat\n" +
                    "Press any other key to go back");
            userInput = userStringInput();
            //return boat;
            if (userInput.equalsIgnoreCase("4"))
                return true;
        }
        // } else {
        //    index++;
        // }
        // }
        // }else{
        //   System.out.println("Press 1 to register a new boat");
        // userInput = userStringInput();
        // }
        return false;
    }

    public UserChoiceInBoatMenu getUserInputInBoatMenu(){
        UserChoiceInBoatMenu choice = null;
        switch (userInput){
            case "1":
                choice = UserChoiceInBoatMenu.ADD_NEW_BOAT;
                break;
            case "2":
                choice = UserChoiceInBoatMenu.CHANGE_BOAT_INFORMATION;
                break;
            case "3":
                choice = UserChoiceInBoatMenu.DELETE_BOAT;
                break;
        }
        return choice;
    }

    public Boat showRegisterNewBoat(Member member){
        Boat boat = null;
        do {
            System.out.println("Please enter length of the boat :");
            double boatLength = correctDouble();
            System.out.println("Please enter boat type(1 for sailboat, 2 for motor sail, " +
                    "3 for kayak/canoe, and 4 for others)");
            BoatType type = correctBoatType();
            try {
                boat = new Boat(type , boatLength);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }while(boat == null);

        return boat;
    }

    public void showRegisterOrChangeABoat(){
        System.out.println("Enter length of the boat");
        length = correctDouble();
        System.out.println("Enter boat type:" +
                "\n1 for Sailboat , 2 for Motor sailor , 3 for Kayak/Canoe, 4 for Others");
        boatType =  correctBoatType();
    }

    public void showAddConfirmation(Boat boat){ System.out.println(boat.getType()+" is added"); }

    private double correctDouble(){
        boolean isValid=false;
        double inputToDouble = 0;
        do{
            try{
                inputToDouble = Double.parseDouble(userStringInput());
                isValid = isValidDouble(inputToDouble);
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }while(!isValid);
        return inputToDouble;
    }

    public void askUserToUpdateBoatData(Boat boat){
        boolean isValid = false;
        do {
            System.out.println("Please enter length of the boat :");
            double boatLength = correctDouble();
            System.out.println("Please enter boat type(1 for sailboat, 2 for motor sail, " +
                    "3 for kayak/canoe, and 4 for others)");
            BoatType type = correctBoatType();
            try {
                boat.setType(type);
                boat.setLength(boatLength);
                isValid = true;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }while(!isValid);
    }

    private void showBoatsOfMember(Member member){
        int index = 1;
        for(Boat boat : member.boatsOwnedByMember()){
            System.out.println((index++) + " Boat type : " + boat.getType() + " boat length : " +
                    boat.getLength());
        }
    }

    public Boat showDeleteOrChangeABoat(Member member){

        showBoatsOfMember(member);
        System.out.println("Enter index of boat to choose or any other key to go back to last menu:");
        int chosenMember = correctInteger();
        int index = 1;
        for(Boat boat : member.boatsOwnedByMember()) {
            if (index == chosenMember) {
                return boat;
            } else {
                index++;
            }
        }
        return null;
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

    public String getName(){ return name; }

    public String getPersonalNumber(){ return personalNumber; }

    public BoatType getBoatType(){ return boatType; }

    public double getLength(){ return length; }

    //check if personal number is valid
    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
    }
}
