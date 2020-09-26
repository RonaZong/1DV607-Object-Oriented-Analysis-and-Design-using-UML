package View;

import Model.Boat;
import Model.BoatClub;
import Model.Member;

public class MemberMenu extends Menu {


    public void showMemberMenu() {

    }

    @Override
    public void showInstruction() {
        System.out.println("Press 1 to show a compact list of members\n" +
                           "Press 2 to show a verbose list of members\n" +
                           "Press 3 to delete a member\n" +
                           "Press 4 to update a member information\n" +
                           "Press 5 to see a specific member data");

    }

    private void actUponUserInputInMainMenu(int userInput) {
        switch (userInput) {
            case 1:
                showCompactList(boatClub);
                break;
            case 2:
                showVerboseList(boatClub);
                break;
            case 3:
                showDeleteMemberMenu();
                break;

        }
    }

    private void showDeleteMemberMenu() {
        System.out.println("Enter the member's name which you want to delete");
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
    }
}
