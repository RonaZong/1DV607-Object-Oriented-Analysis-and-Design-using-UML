package BlackJack;

import BlackJack.Controller.PlayGame;
import BlackJack.Model.Game;
import BlackJack.View.IView;
import BlackJack.View.SimpleView;

public class Program {
    public static void main(String[] args) {
        Game g = new Game();
        IView v = new SimpleView(); //new SwedishView();
        PlayGame ctrl = new PlayGame();

        while (ctrl.Play(g, v));
    }
}
