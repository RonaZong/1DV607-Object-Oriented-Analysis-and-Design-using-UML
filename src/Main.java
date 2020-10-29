import Controller.MainController;
import Model.BoatClub;
import Model.Member;
import Model.Registry;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {
        Registry registry = new Registry("Registry.txt");
        BoatClub boatClub = new BoatClub();
        StartMenu startMenu = new StartMenu();
        MainController mainController = new MainController(boatClub, startMenu);

        boatClub.polulate(registry.loadTextFromFile());
        boatClub.addMember(new Member("199901011234", "rona", "1234", 0));

        mainController.memberAction();
        registry.saveTextToFile(boatClub.save());
    }
}
