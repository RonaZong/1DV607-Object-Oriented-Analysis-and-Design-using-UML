package Controller;

import Model.BoatClub;
import View.Menu;
import View.StartMenu;

public class MainController {

    private Menu menu;
    private MemberCreationController controller;
    
    public MainController(Menu console) {

        this.controller=new MemberCreationController();
        this.menu = console;
    }

    public void memberAction(BoatClub boatClub){

        this.menu.showInstruction();
        controller.userWantsToAddMember(boatClub);
       // menu.showInstruction();
    }
}
