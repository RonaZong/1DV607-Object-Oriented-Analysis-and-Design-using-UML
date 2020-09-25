import Model.BoatClub;
import View.Menu;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {


        BoatClub boatClub = new BoatClub();
        Menu console = new StartMenu();
        console.showInstruction(console);
    }
}
