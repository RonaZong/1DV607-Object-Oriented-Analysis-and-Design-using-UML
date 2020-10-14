package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class MemberMenu {

    private Scanner sc = new Scanner(System.in);
    private BoatClub boatClub;
    private Member member;
    private boolean alreadyMember = false;


    public MemberMenu(BoatClub boatClub) {
        this.boatClub = boatClub;
    }

    public void showMemberMenu(){
        System.out.println("----Members' menu----\n" +
                "Press 1 to register as a member\n" +
                "Press 2 to update the information of a member\n" +
                "Press 3 to delete a member\n" +
                "Press 4 to see the information of a specific member\n" +
                "Press 5 to Boat Menu\n" +
                "Press 0 to quit\n");
        int userInput = sc.nextInt();
        actUponUserInputInMemberMenu(userInput, this.boatClub);
    }

    public void actUponUserInputInMemberMenu(int userInput, BoatClub boatClub) {
        switch (userInput) {
            case 1:
                createMemberMenu();
                break;
            case 2:
                showUpdateMemberMenu();
                break;
            case 3:
                boatClub.deleteMember(this.member);
                break;
            case 5:
                BoatMenu boatMenu = new BoatMenu(this.boatClub, this.member);
                boatMenu.showBoatMenu();
                break;
            case 0:
                System.exit(1);
        }
    }

<<<<<<< Updated upstream
    public void createMemberMenu(){
        System.out.println("----- Become a Member ----\n-" +
                "In order to be a member you have to enter following information : \n" +
                "Please enter user name: ");
        String name = sc.nextLine();
=======
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
        if(member.numberOfBoats()>0)
             System.out.println("this member boat information is :");
        for (Boat boat : member.boatsOwnedByMember()) {
            System.out.println((index++) + " - Boat type :" + boat.getType() +
                    ", Boat Length : " + boat.getLength());
        }
>>>>>>> Stashed changes

        System.out.print("Please enter personal number: ");
        String personalNumber = sc.nextLine();
        this.boatClub.creatMember(name, personalNumber);
        // this.alreadyMember = true;
    }

<<<<<<< Updated upstream
    private void showUpdateMemberMenu() {
        System.out.println("What do you want to update?");
        System.out.println("If you want to update name enter your new name otherwise press enter");
        String name = sc.nextLine();
        //do we need to check for validate personal number??
        //Yes
=======
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
            default:
                choice = UserChoiceInBoatMenu.GO_BACK;
                break;
        }
        return choice;
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
>>>>>>> Stashed changes

        System.out.println("If you want to update your personal number enter your new personal" +
                "number otherwise press enter");
        String personalNumber = sc.nextLine();
        this.boatClub.updateMemberInformation(this.member, name, personalNumber);
    }
}
