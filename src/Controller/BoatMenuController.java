package Controller;

import Model.BoatClub;
import View.BoatMenu;

import java.lang.reflect.Member;

public class BoatMenuController {
    private BoatMenu menu;
    private Member member;


    public void acrUponUserInputInBoatMenu(BoatClub boatClub){
        menu = new BoatMenu();
        menu.showInstruction();
        BoatMenu.UserChoiceInBoatMenu choice = menu.getUserInputInBoatMenu();
        switch (choice){
            case ADD_NEW_BOAT:
                member= (Member) boatClub.getMember(menu.ShowAccessToMember());
                menu.showRegisterABoat(boatClub, (Model.Member) member);
                break;
            case DELETE_BOAT:
                menu.showChangeInformation(boatClub);
                break;
            case CHANGE_BOAT_INFORMATION:
                menu.showDeleteBoat(boatClub);
        }
    }
}
