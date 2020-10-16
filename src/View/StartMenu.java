package View;

import Model.Member;
import Util.UserChoiceInStartMenu;

public class StartMenu extends menu {

    public void showInstruction() {

        System.out.println("Welcome to Boat Club\n" +
                "-----------------------\n" +
                "Press 1 to add a new member\n" +
                "Press 2 to go to member menu\n" +
                "Press 3 to see the instruction\n" +
                "Press 4 to save\n" +
                "Press 5 to quit");
    }


    public UserChoiceInStartMenu getUserInputInStartMenu() {
        UserChoiceInStartMenu choice = null;

            String userInput = userStringInput();
            switch (userInput) {
                case "1":
                    choice = UserChoiceInStartMenu.ADD_NEW_MEMBER;
                    break;
                case "2":
                    choice = UserChoiceInStartMenu.MEMBER_MENU;
                    break;
                case "3":
                    choice = UserChoiceInStartMenu.SEE_INSTRUCTION;
                    break;
                case "4":
                    choice = UserChoiceInStartMenu.SAVE;
                    break;
                case "5":
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
            long personalNumber = correctLong();
            try {
                    member = new Member(name, (personalNumber+""));
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }while (member == null);
        return member;
    }

    public void confirmationMsg(Member member){
        System.out.println("\n" + member.getName() +" is added\n");
    }

    public boolean userWantsToAddMoreMember() {

        String answer ="";
        do {
            System.out.println("Do you want to add another member\n" +
                    "Press \"yes\" to add a new member or \"no\" to go back to start menu");
            answer = userStringInput();
        }while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
        return answer.equalsIgnoreCase("yes");
    }

    public void showInstructionOfProgram(){
        System.out.println("For checking the list of members whether in detail or just a compact list you can go\n" +
                "to member menu and choose which kind of list you want to see\n\n" +
                "For see a specific member's information or update or delete a member information\n" +
                "you need to go to \"member menu\" and then \"compact list\" then choose\n" +
                "index number of that member and choose your desired option\n\n" +
                "For adding or updating or deleting a member's boat you need to first go to a \"specific member's\n" +
                "information\" then choose your desired option there\n\n" +
                "For saving information you need to save all changes you made before you quit the program.\n");
        goBackToStartMenu();
    }

    public void showSaveMsg(){
        System.out.println("The information is saved");
    }
    }
