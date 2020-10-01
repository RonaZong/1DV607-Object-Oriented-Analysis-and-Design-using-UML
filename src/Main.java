import Controller.MainController;
import Model.BoatClub;
import Model.Member;
import View.MemberMenu;
import View.Menu;
import View.StartMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BoatClub boatClub = new BoatClub();
        StartMenu menu=new StartMenu();

        MainController user = new MainController(boatClub, menu);

        user.memberAction(boatClub);

    }
}
