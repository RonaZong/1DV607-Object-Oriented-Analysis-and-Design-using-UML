package Controller;

import Model.BoatClub;
import View.*;

public class MainController {

    private Menu menu;
    private MemberCreationController controller;
    
    public MainController(Menu console) {

        this.controller=new MemberCreationController();
        this.menu = console;
    }

    //every scenarios would happen in this method
    public void memberAction(BoatClub boatClub){

        this.menu.showInstruction();
        actUponUserInputInStartMenu();
        controller.userWantsToAddMember(boatClub);

    }

    private void actUponUserInputInStartMenu(  ) {
        StartMenu menu = new StartMenu();
        boolean IWantToQuit = false;
        while(IWantToQuit) {
            StartMenu.UserChoiceInMainMenu userChoice = menu.getUserInputInMainMenu();
            switch (userChoice) {
                case ADD_NEW_MEMBER:
                    showRegisterMenu();
                    IWantToQuit = true;
                    break;
                case MEMBER_MENU:
                    showMemberMenu();
                    break;
                case BOAT_MENU:
                    showBoatMenu();
                    break;
                case QUIT:
IWantToQuit=true;
                    break;

            }
        }
    }

    private void showBoatMenu() {
        Menu menu = new BoatMenu();
        menu.showInstruction();
    }

    private void showMemberMenu() {
        Menu menu = new MemberMenu();
        menu.showInstruction();
    }

    private void showRegisterMenu() {
        Menu menu = new MemberCreationMenu();
        menu.showInstruction();
    }
}
