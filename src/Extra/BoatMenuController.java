package Extra;

import Model.BoatClub;
import Model.Member;
import View.BoatMenu;
import Util.UserChoiceInBoatMenu;

public class BoatMenuController {
    private BoatMenu menu;
    private Member member;

   /* public void actUponUserInputInBoatMenu(BoatClub boatClub){
        menu = new BoatMenu();
        menu.showInstruction();
        UserChoiceInBoatMenu choice = menu.getUserInputInBoatMenu();

        switch (choice){
            case ADD_NEW_BOAT:
                member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showRegisterABoat();
                member.registerNewBoat(menu.getBoatType(),menu.getLength());
                break;
            case DELETE_BOAT:
                member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showDeleteBoat(boatClub, member);
            case CHANGE_BOAT_INFORMATION:
                member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showChangeInformation();
                break;

        }
    }*/
}
