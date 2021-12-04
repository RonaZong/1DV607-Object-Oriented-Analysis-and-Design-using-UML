import Controller.MainController;
import Model.BoatClub;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {

        BoatClub boatClub = new BoatClub();
        StartMenu menu=new StartMenu();

        MainController user = new MainController(boatClub);

        user.memberAction(menu);
    }
}
