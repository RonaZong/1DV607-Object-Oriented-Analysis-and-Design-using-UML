package Controller;

import Model.BoatClub;
import Util.UserChoiceInStartMenu;
import View.*;

public class MainController {

    private MemberCreationController controller;
    private StartMenu menu;
    private MemberMenu memberMenu;
    
    public MainController(StartMenu console,MemberMenu memberMenu) {

        this.controller=new MemberCreationController();
        this.menu = console;
        this.memberMenu =memberMenu;

    }

    //every scenarios would happen in this method
    public void memberAction(BoatClub boatClub){

       while(!actUponUserInputInStartMenu(menu,boatClub)) ;

    }

    private boolean actUponUserInputInStartMenu(StartMenu menu, BoatClub boatClub) {

            this.menu.showInstruction();
            UserChoiceInStartMenu userChoice = menu.getUserInputInStartMenu();

            switch (userChoice) {
                case ADD_NEW_MEMBER:
                    controller.userWantsToAddMember(boatClub);
                    break;
                case MEMBER_MENU:
                    MemberMenuController memberMenuController =new MemberMenuController();
                    memberMenuController.actUponUserInputInMemberMenu(boatClub);
                    break;
                case BOAT_MENU:
                    BoatMenuController boatMenuController = new BoatMenuController();
                    boatMenuController.acrUponUserInputInBoatMenu(boatClub);
                    //showBoatMenu();
                    break;
                case QUIT:
                    System.exit(1);
                    // return to previous menu or exit directly
                return true;

            }
        return false;
    }

//    private void showBoatMenu() {
//        Menu menu = new BoatMenu();
//        menu.showInstruction();
//    }

    private void showMemberMenu() {
        Menu menu = new MemberMenu();
        menu.showInstruction();
    }

    private void showRegisterMenu() {
        Menu menu = new MemberCreationMenu();
        menu.showInstruction();
    }
}
