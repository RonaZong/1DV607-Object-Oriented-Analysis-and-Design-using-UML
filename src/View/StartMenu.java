package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

import java.util.Scanner;

public class StartMenu {
<<<<<<< Updated upstream
    private Scanner sc = new Scanner(System.in);
    private BoatClub boatClub;

    public StartMenu(BoatClub boatClub) {
        this.boatClub = boatClub;
=======
    private String userInput;
    private String name;
    private String personalNumber;

    /** create member in the view, send it to controller, and controller send it to registry.
     * the validation "isValid" should be in the model */

    private String userStringInput(){
        Scanner sc =new Scanner(System.in);
        return sc.nextLine();
>>>>>>> Stashed changes
    }

    public void welcomeMessage(){
        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
<<<<<<< Updated upstream
                "Press 1 to Member Menu\n" +
                "Press 2 to see a compact list of members\n"+
                "Press 3 to see a full detailed list of members\n"+
                "Press 4 to see the information of a specific member\n"+
                //who can have access to a specific member's information?
                // "press 3 to check member's information \n" +
                "Press 0 to quit \n");
                // do we need to have an admin so can have access to member's information?
        int userInput = sc.nextInt();

        actUponUserInputInMainMenu(userInput, boatClub);


           // showMemberMenu();
           /* int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createMemberMenu(boatClub);
=======
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
>>>>>>> Stashed changes
                    break;
                case 2:
                    showList(boatClub);
                    break;

<<<<<<< Updated upstream
            }*/
    }

    public void actUponUserInputInMainMenu(int userInput, BoatClub boatClub) {
        switch (userInput) {
            case 1:
                MemberMenu memberMenu = new MemberMenu(boatClub);
                memberMenu.showMemberMenu();
                break;
            case 2:
                showCompactList(boatClub);
                break;
            case 3:
                showVerboseList(boatClub);
                break;
            case 4:
                showSpecificMemberData(boatClub);
                break;
            case 0:
                System.exit(1);
        }
    }


=======
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

   /* public void userWantsToAddBoat(Member member){
        System.out.println("Please enter numbers of boats:");
        int numberOfBoats = correctInteger();
        for(int i = 0 ; i<numberOfBoats;i++){
            boolean isvalid = false;
            do {
                System.out.println("Please enter length of the boat " + (i + 1) + ":");
                double boatLength = correctDouble();
                System.out.println("Please enter boat type(1 for sailboat, 2 for motor sail, " +
                        "3 for kayak/canoe, and 4 for others)");
                BoatType type = correctBoatType();
                try {
                    member.registerNewBoat(type, boatLength);
                    isvalid = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }while(!isvalid);

        }
    }*/

    //check if correct integer used by user
    private int correctInteger(){
        boolean isValid=false;
         int inputToInteger=0;
        do{
            try{
                inputToInteger = Integer.parseInt(userStringInput());
                isValid = isPositive(inputToInteger);
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
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
                isValid= true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
        }while(!isValid);
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
>>>>>>> Stashed changes

    private void showSpecificMemberData(BoatClub boatClub) {

    }

<<<<<<< Updated upstream
    public void showList(BoatClub boatClub){
        System.out.print("----- Show list of members -----\n"+
                " What kind of list, press 1 for compact list, press 2 for verbose list: ");
        int enter = sc.nextInt();

        if (enter==1){
            //showCompactList();
        }else if(enter==2){
            //showVerboseList();
        }else {
            //error
        }
    }



    public void showCompactList(BoatClub boatClub){
        for(Member member : boatClub.getAllMember()) {
            System.out.println("This member name is : " + member.getName() +
                    "\nwith memberID of : " + member.getMemberID() +
                    "\nwhich has " + member.boatsOwnedByMember().size() + "boats" +
                    "\n------------\n");
        }
    }

    public void showVerboseList(BoatClub boatClub){
        for(Member member : boatClub.getAllMember()){
            System.out.println("This member name is : " + member.getName() +
                           "\nwith personal number of " + member.getPersonalNumber() +
                            "\nwith memberID of " + member.getMemberID());
        //it might give a null exception
            System.out.println("This member has " + member.boatsOwnedByMember().size() + "boats");
            if(member.boatsOwnedByMember().size()> 0 ) {
                System.out.println("this member boat information is :");
                for (Boat boat : member.boatsOwnedByMember()) {
                    System.out.println("Boat type :" + boat.getType() +
                            "\nBoat color : " + boat.getLength());
                }
            }
        }
=======
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
>>>>>>> Stashed changes
    }
}
