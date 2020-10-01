package Controller;

import Model.BoatClub;
import Util.UserChoiceInBoatMenu;
import View.BoatMenu;

import java.lang.reflect.Member;

public class BoatMenuController {
    private BoatMenu menu;
    private Model.Member member;


    public void acrUponUserInputInBoatMenu(BoatClub boatClub){
        menu = new BoatMenu();
        menu.showInstruction();
        UserChoiceInBoatMenu choice = menu.getUserInputInBoatMenu();
        switch (choice){
            case ADD_NEW_BOAT:
                member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showRegisterABoat(boatClub, member);
                member.registerNewBoat(menu.getBoatType(),menu.getLength());
                break;
            case CHANGE_BOAT_INFORMATION:
                member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showChangeInformation(boatClub, member);
                break;
            case DELETE_BOAT:
                member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showDeleteBoat(boatClub, member);
        }
    }
}
