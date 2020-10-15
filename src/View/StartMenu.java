package View;

import Model.Member;
import Util.UserChoiceInStartMenu;

public class StartMenu extends menu {
    private String userInput;

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
            String name = userStringInput();
            System.out.print("Please enter personal number in 10 digits: ");
            int personalNumber = correctInteger();
            try {
                    member = new Member(name, (personalNumber+""));
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }while (member == null);
        return member;
    }

   /* public void userWantsToAddBoat(Member member){
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
    }*/

    public void confirmationMsg(Member member){
        System.out.println(member.getName() +" is added");
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
