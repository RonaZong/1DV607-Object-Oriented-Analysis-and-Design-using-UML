import Model.BoatClub;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {

        BoatClub boatClub = new BoatClub();
        StartMenu console = new StartMenu(boatClub);
        console.welcomeMessage();
    }
}
