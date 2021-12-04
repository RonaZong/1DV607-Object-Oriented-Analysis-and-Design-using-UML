package DiceGame;

import DiceGame.Controller.Player;
import DiceGame.Model.DiceGame;
import DiceGame.View.Console;

public class Program {

    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        Console view = new Console();
        Player controller = new Player(view);

        controller.playGame(game);
    }
}
