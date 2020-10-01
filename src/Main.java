import Controller.MainController;
import Model.BoatClub;
import Model.Member;
import View.MemberMenu;
import View.StartMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BoatClub boatClub = new BoatClub();

        MemberMenu memberMenu = new MemberMenu();
        StartMenu menu=new StartMenu();

        MainController user = new MainController(menu, memberMenu);
        //MainController user = new MainController(boatClub, menu, memberMenu);
        //MainController only take two parameters but here u changed it and did it with three parameters
        //I didnt get it why
        /* public MainController(StartMenu console,MemberMenu memberMenu) {
        this.controller=new MemberCreationController();
        this.menu = console;
        this.memberMenu =memberMenu;

    }*/
         user.memberAction(boatClub);
     //   user.memberAction();

    }
}
