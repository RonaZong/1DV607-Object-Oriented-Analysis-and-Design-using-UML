import Model.BoatClub;
import View.Menu;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {

        int input = 1;
        BoatClub boatClub = new BoatClub();
        Menu console = new StartMenu();
        console.showInstruction(1,console);
    }
}
