package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.UserChoiceInMemberMenu;

import java.util.Scanner;

public class MemberMenu extends Menu {
    private int userInput;
    private Scanner sc;
    private String name;
    private String personalNumber;

    private int userIntInput(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }


    public void showMemberMenu() {

    }

    @Override
    public void showInstruction() {
        System.out.println("Press 1 to show a compact list of members\n" +
                           "Press 2 to show a verbose list of members\n" +
                           "Press 3 to delete a member\n" +
                           "Press 4 to update a member information\n" +
                           "Press 5 to see a specific member data");

        userInput = userIntInput();

    }

    public UserChoiceInMemberMenu getUserInputInMemberMenu() {
        UserChoiceInMemberMenu choice = null;

        switch (userInput) {

            case 1:
                choice = UserChoiceInMemberMenu.COMPACT_LIST;
                break;
            case 2:
                choice = UserChoiceInMemberMenu.VERBOSE_LIST;
                break;
            case 6:
                choice = UserChoiceInMemberMenu.QUIT;
                break;

        }
        return choice;
    }

    public UserChoiceInMemberMenu getInputInCompactList() {
        UserChoiceInMemberMenu choice = null;

        switch(userInput){
            case 1:
                choice = UserChoiceInMemberMenu.DELETE;
                break;
            case 2:
                choice = UserChoiceInMemberMenu.UPDATE;
                break;
            case 3:
                choice = UserChoiceInMemberMenu.SPECIFIC_MEMBER;
                break;
        }
        return choice;
    }

    public Member showCompactList(BoatClub boatClub){
        int index =1;
        for(Member member : boatClub.getAllMembersFromRegistry()) {
            System.out.println((index++) + ":This member name is : " + member.getName() +
                    "\nwith memberID of : " + member.getMemberID() +
                    "\nwhich has " + member.getNumbersOfBoatsOwnByAMember() + "boats" +
                    "\n------------\n");
        }
      System.out.println("Enter index of member to choose:");
        int input = userIntInput();
        index = 1;
        for(Member member : boatClub.getAllMembersFromRegistry()){
            if(index==input){
                return member;
            }
            index++;
        }
        return null;
    }

    public void showVerboseList(BoatClub boatClub){
        for(Member member : boatClub.getAllMembersFromRegistry()){
            System.out.println("This member name is : " + member.getName() +
                    "\nwith personal number of " + member.getPersonalNumber() +
                    "\nwith memberID of " + member.getMemberID());
            //it might give a null exception
            System.out.println("This member has " + member.getNumbersOfBoatsOwnByAMember()+ "boats");

                System.out.println("this member boat information is :");
                for (Boat boat : member.boatsOwnedByMember()) {
                    System.out.println("Boat type :" + boat.getType() +
                            "\nBoat Length : " + boat.getLength());

            }
            System.out.println("\n----------------------\n");
        }
    }

    public void showUpdateMenu(){
        System.out.println("What do you want to update?");
        System.out.println("If you want to update name enter your new name otherwise press enter");
        name = userStringInput();
        System.out.println("if you want to update your personal number enter your new personal" +
                "number otherwise press enter");
        do {
            personalNumber = userStringInput();
        }while (!isValid(personalNumber));

    }

    public void showConfirmationMsg(Member member){
        System.out.println(member.getName() + " is deleted");

    }

    public void showMemberInformation(Member member){

    }

    public String getName(){
        return name;
    }

    public String getPersonalNumber(){
        return personalNumber;
    }

    private boolean isValid(String input){
        return input.length() == 10 && input.matches("-?\\d+(\\.\\d+)?");
        //check its digits
    }
}
