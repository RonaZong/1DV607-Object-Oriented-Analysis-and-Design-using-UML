package Controller;

import Model.BoatClub;
import Util.UserChoiceInStartMenu;
import View.*;

public class MainController {

//    private MemberCreationController controller;
    private BoatClub boatClub;
    private StartMenu menu;
//    private MemberMenu memberMenu;
    
    public MainController(BoatClub boatClub, StartMenu console) {
        this.boatClub = boatClub;
//        this.controller = new MemberCreationController();
        this.menu = console;
//        this.memberMenu =memberMenu;

    }

    //every scenarios would happen in this method
//    public void memberAction(BoatClub boatClub){
//
//       while(!actUponUserInputInStartMenu(menu,boatClub)) ;
//
//    }

    public void memberAction(BoatClub boatClub){

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
            case BOAT_MENU:
                BoatMenuController boatMenuController = new BoatMenuController();
                boatMenuController.actUponUserInputInBoatMenu(boatClub);
                //showBoatMenu();
                break;
            case QUIT:
                return true;

        }
        return false;
    }

//    private void showBoatMenu() {
//        Menu menu = new BoatMenu();
//        menu.showInstruction();
//    }

//    private void showRegisterMenu() {
//        Menu menu = new MemberCreationMenu();
//        menu.showInstruction();
//    }

//    private void showMemberMenu() {
//        Menu menu = new MemberMenu();
//        menu.showInstruction();
//    }

}
