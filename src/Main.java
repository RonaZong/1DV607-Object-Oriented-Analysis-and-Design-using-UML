import Controller.MainController;
import Model.BoatClub;
import Model.Registry;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {
        Registry registry = new Registry("Registry.txt");
        BoatClub boatClub = new BoatClub();
        StartMenu startMenu = new StartMenu();
        MainController mainController = new MainController(boatClub, startMenu);

        mainController.memberAction();
        registry.saveTextToFile(mainController.save());
    }
}
