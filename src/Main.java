import Model.BoatClub;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {

        BoatClub boatClub = new BoatClub();
<<<<<<< Updated upstream
        StartMenu console = new StartMenu(boatClub);
        console.welcomeMessage();
=======
        StartMenu menu=new StartMenu();

        MainController user = new MainController(boatClub);

        user.memberAction(menu);
>>>>>>> Stashed changes
    }
}
