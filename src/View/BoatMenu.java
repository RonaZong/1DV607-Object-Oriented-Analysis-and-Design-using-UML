package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.BoatType;
import Util.UserChoiceInBoatMenu;

import java.util.Scanner;

public class BoatMenu extends Menu {
    private int userInput;
    private BoatType boatType;
    private Scanner sc;
    private String memberName;
    private float length;


//    public enum UserChoiceInBoatMenu{
//        ADD_NEW_BOAT, DELETE_BOAT, CHANGE_BOAT_INFORMATION
//    }

    private int userIntInput(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private float userFloatInput(){
        sc = new Scanner(System.in);
        return sc.nextFloat();
    }

    private String userStringInput(){
        sc =new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void showInstruction() {
        System.out.println("Press 1 to register a new boat\n"+
                "Press 2 to delete a boat\n"+
                "Press 3 to change the boat’s information");
        //System.out.println("enter your boat information");
        userInput=userIntInput();
    }

    public UserChoiceInBoatMenu getUserInputInBoatMenu(){
        UserChoiceInBoatMenu choice = null;
        switch (userInput){
            case 1:
                choice = UserChoiceInBoatMenu.ADD_NEW_BOAT;
                break;
            case 2:
                choice = UserChoiceInBoatMenu.DELETE_BOAT;
            case 3:
                choice = UserChoiceInBoatMenu.CHANGE_BOAT_INFORMATION;
        }
        return choice;
    }

    public String ShowAccessToMember(){
        System.out.print("For access the boat, pleas enter user name: ");
        memberName = userStringInput();
        return memberName;
    }

    public void showRegisterABoat(BoatClub boatClub,Member member){
        System.out.println("Enter boat type:" +
                "\n0 for Sailboat , 1 for Motor sailor , 2 for Kayak/Canoe, 3 for Others");
        int typeValue = userIntInput();
        System.out.println("Enter length of the boat");
        length = userFloatInput();

    }
    public void showChangeInformation(BoatClub boatClub, Member member){
        System.out.println("Which boat your want to change");
        //not sure how to iterate and show boats yet, and how user choose boat
        //by type? by length
        for (Boat b: member.boatsOwnedByMember()){
            System.out.println(b);
        }
    }
    public void showDeleteBoat(BoatClub boatClub, Member member){
        System.out.println("Which boat your want to change");
        //not sure how to iterate and show boats yet, and how user choose boat
        //by type? by length
        for (Boat b: member.boatsOwnedByMember()){
            System.out.println(b);
        }
    }
//    private void askForABoatDataToRegister(Member member, Boat boat) {
//        System.out.println("enter boat type:" +
//                "\n0 for Sailboat , 1 for Motor sailor , 2 for Kayak/Canoe, 3 for Others");
//        int typeValue = userIntInput();
//        System.out.println("Enter length of the boat");
//        int length = userIntInput();
//        member.registerNewBoat(Util.BoatType.values()[typeValue] , length);
//    }

    public BoatType getBoatType(){
        return boatType;
    }

    public Float getLength(){
        return length;
    }
}
