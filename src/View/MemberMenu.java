package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.BoatType;
import Util.UserChoiceInBoatMenu;
import Util.UserChoiceInMemberMenu;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemberMenu extends menu{
    private String userInput;

    public void showInstruction() {
        System.out.println("Press 1 to show a compact list of members\n" +
                           "Press 2 to show a verbose list of members\n" +
                            "Press any key to go back to main menu");
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

    //assign choice of user in creating a new member  to a enum to use in controller
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
        try {//if list is empty
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
        userInput="";//to not get null error in getInputInCompactList()
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

    public void showUpdateMemberMenu(Member member){
        boolean isValid = false;
        System.out.println("Enter new name");
        String name = userStringInput();
        do {
            System.out.println("Enter new 10 digits personal number");
             int personalNumber = correctInteger();
             try {
                 member.updateMemberInformation(name, (personalNumber + ""));
                 isValid = true;
             }catch (IllegalArgumentException ex){
                 System.out.println(ex.getMessage());
             }
        }while (!isValid);
    }

    public void showDeletedMemberConfirmationMsg(Member member){
        System.out.println(member.getName() + " is deleted");

    }

    public void showUpdatedMemberConfirmationMsg(Member member){
        System.out.println(member.getName() + " is updated");
    }

    public void showMemberInformation(Member member) {
        System.out.println("This member name is : " + member.getName() +
                "\nwith personal number of " + member.getPersonalNumber() +
                "\nwith memberID of " + member.getMemberID());
        System.out.println("This member has " + member.numberOfBoats() + "boats");
        int index=1;
        if(member.numberOfBoats() != 0)
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
                    "Or press any key to go back to main menu");
            userInput = userStringInput();
            if (!userInput.equalsIgnoreCase("1"))
                return true;
        }
        else {
            System.out.println("Press 1 to register a bew boat\n" +
                    "Press 2 to update the boat information\n" +
                    "Press 3 to delete the boat\n" +
                    "Press any other key to go back");
            userInput = userStringInput();
            //return boat;
            List<String> options = Arrays.asList("1" , "2" , "3");

            if (!options.contains(userInput) )
                return true;
        }
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
        }
        return choice;
    }

    public Boat showRegisterNewBoatMenu(Member member){
        Boat boat = null;
        do {
            System.out.println("Please enter length of the boat :");
            double boatLength = correctDouble();
            System.out.println("Please enter boat type(1 for sailboat, 2 for motor sail, " +
                    "3 for kayak/canoe, and 4 for others)");
            BoatType type = correctBoatType();
            try {
                boat = new Boat(type , boatLength);
                member.registerANewBoat(boat);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }while(boat == null);
        return boat;
    }

    public void showAddedBoatConfirmation(Boat boat){ System.out.println(boat.getType()+" is added"); }

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

    public Boat showDeleteOrChangeABoat(Member member , UserChoiceInBoatMenu choice){
        Boat boatFound = null;
       // Boat foundedBoat = null;
            showBoatsOfMember(member);
            System.out.println("Enter index of boat to choose or any other key to go back to last menu:");
            int chosenMember = super.correctInteger();
             int index = 1;
            for(Boat boat : member.boatsOwnedByMember()){//when we iterate on a loop we can't remover or add an element
                if (index == chosenMember) {
                    boatFound = boat;
                    //return boat;
                        // member.deleteBoat(boatFound);//better to have it here or in controller?
                } else{
                        index++;
                    }
                }
        try {
           boatFound = member.memberSelectABoat(boatFound);// to check if it s null or not(do u have any  better idea how to handle it
            if(choice == UserChoiceInBoatMenu.CHANGE_BOAT_INFORMATION)
                askUserToUpdateBoatData(boatFound);
            else if(choice == UserChoiceInBoatMenu.DELETE_BOAT)
                member.deleteBoat(boatFound);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return boatFound;
    }

    public void showUpdatedBoatConfirmation(Boat boat){System.out.println(boat.getType() + " is updated");}

    public void showDeletedBoatConfirmation(Boat boat){System.out.println(boat.getType() + " is deleted");}

        System.out.println("If you want to update your personal number enter your new personal" +
                "number otherwise press enter");
        String personalNumber = sc.nextLine();
        this.boatClub.updateMemberInformation(this.member, name, personalNumber);
    }
}
