package Controller;

import Model.BoatClub;
import View.*;

public class MainController {


    private MemberCreationController controller;
    private StartMenu menu;
    
    public MainController(StartMenu console) {

        this.controller=new MemberCreationController();
        this.menu = console;

    }

    //every scenarios would happen in this method
    public void memberAction(BoatClub boatClub){


        actUponUserInputInStartMenu(this.menu,boatClub);





        actUponUserInputInStartMenu(this.menu,boatClub);
    }

    private void actUponUserInputInStartMenu( StartMenu menu ,BoatClub boatClub) {

        boolean IWantToQuit = false;
        while(!IWantToQuit) {
            this.menu.showInstruction();
            StartMenu.UserChoiceInStartMenu userChoice = menu.getUserInputInStartMenu();

            switch (userChoice) {
                case ADD_NEW_MEMBER:
                    controller.userWantsToAddMember(boatClub);
                    IWantToQuit=true;
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
