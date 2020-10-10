package Controller;

import Model.BoatClub;
import Util.UserChoiceInStartMenu;
import View.*;

public class MainController {

    private BoatClub boatClub;
    private StartMenu menu;

    public MainController(BoatClub boatClub, StartMenu console) {
        this.boatClub = boatClub;
        this.menu = console;
    }

    //every scenarios would happen in this method
    public void memberAction(){
        while(!actUponUserInputInStartMenu()) ;
    }

    private boolean actUponUserInputInStartMenu() {

        this.menu.showInstruction();
        UserChoiceInStartMenu userChoice = this.menu.getUserInputInStartMenu();

        switch (userChoice) {
            case ADD_NEW_MEMBER:
                MemberCreationController memberCreationController = new MemberCreationController();
                memberCreationController.userWantsToAddMember(boatClub);
                break;
            case MEMBER_MENU:
                MemberMenuController memberMenuController =new MemberMenuController();
                memberMenuController.actUponUserInputInMemberMenu(boatClub);
                break;
            case QUIT:
                return true;
        }
        return false;
    }

}
