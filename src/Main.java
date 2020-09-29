import Controller.MainController;
import Model.BoatClub;
import Model.CompactListSave;
import View.Menu;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {


        BoatClub boatClub = new BoatClub();

        Menu console = new StartMenu();
        StartMenu menu=new StartMenu();
        MainController user = new MainController(menu);
        user.memberAction(boatClub);
    }
}
