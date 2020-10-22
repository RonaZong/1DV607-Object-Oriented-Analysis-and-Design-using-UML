import Controller.PlayGame;
import Model.Game;
import View.IView;
import View.SimpleView;

public class Program {

    public static void main(String[] a_args)
    {
        Game game = new Game();
        IView view = new SimpleView(); //new SwedishView();
        PlayGame ctrl = new PlayGame();

        while (ctrl.Play(game, view));
    }
}
