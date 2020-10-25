import Controller.PlayGame;
import Model.Game;
import View.IView;
import View.SimpleView;

public class Main {

    public static void main(String[] a_args)
    {
        Game game = new Game();
        IView view = new SimpleView(); //new SwedishView();
        PlayGame ctrl = new PlayGame(game, view);

        while (ctrl.Play());
    }
}
