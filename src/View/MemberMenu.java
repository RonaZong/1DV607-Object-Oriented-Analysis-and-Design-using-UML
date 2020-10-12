package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.UserChoiceInBoatMenu;
import Util.UserChoiceInMemberMenu;

import java.util.Scanner;

public class MemberMenu extends Menu {
    private String userInput;
    private Scanner sc;
    private String name;
    private String personalNumber;

    //can be removed
    private int userIntInput(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }


    @Override
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
        for(Member member : boatClub.getAllMembersLocally()) {
            System.out.println((index++) + ":This member name is : " + member.getName() +
                    "\nwith memberID of : " + member.getMemberID() +
                    "\nwhich has " + member.getNumbersOfBoatsOwnByAMember() + "boats" +
                    "\n------------\n");
        }

        System.out.println("Enter index of member to choose:");
        int chosenMember = correctInteger();
        index = 1;
        for(Member member : boatClub.getAllMembersFromRegistry()) {
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
        userInput="";//to not get null error in line 59 in getInputInCompactList()
        return null;
    }
    // how to read them categorised from txt file

    public void showVerboseList(BoatClub boatClub){
        for(Member member : boatClub.getAllMembersFromRegistry()){
           showMemberInformation(member);
            System.out.println("\n----------------------\n");
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

    public Boat showMemberInformation(Member member) {
        System.out.println("This member name is : " + member.getName() +
                "\nwith personal number of " + member.getPersonalNumber() +
                "\nwith memberID of " + member.getMemberID());
        //it might give a null exception
        System.out.println("This member has " + member.getNumbersOfBoatsOwnByAMember() + "boats");
        int index=1;
        System.out.println("this member boat information is :");
        for (Boat boat : member.boatsOwnedByMember()) {
            System.out.println((index++) + " - Boat type :" + boat.getType() +
                    ", Boat Length : " + boat.getLength());
        }
        System.out.println("Enter index of boat to choose or any other key to go back to last menu:");
        String chosenMember = userStringInput();
        index = 1;
        for(Boat boat : member.boatsOwnedByMember()) {
            if (index == Integer.parseInt(chosenMember)) {
                System.out.println("Press 1 to register a new boat\n" +
                        "Press 2 to update the boat information\n" +
                        "Press 3 to delete the boat");

                userInput = userStringInput();
                return boat;
            } else {
                index++;
            }
        }

        return null;
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

    public String getName(){
        return name;
    }

    public String getPersonalNumber(){
        return personalNumber;
    }

    //check if personal number is valid
    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
    }
}
