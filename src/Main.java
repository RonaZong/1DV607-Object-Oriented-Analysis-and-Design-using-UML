import Controller.MainController;
import Model.BoatClub;
import Model.CompactListSave;
import View.MemberMenu;
import View.Menu;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {


        BoatClub boatClub = new BoatClub();

        MemberMenu memberMenu = new MemberMenu();
        StartMenu menu=new StartMenu();

//        MainController user = new MainController(menu, memberMenu);
        MainController user = new MainController(boatClub, menu, memberMenu);
//        user.memberAction(boatClub);
        user.memberAction();

    }
}
