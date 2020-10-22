package Controller;

import Model.Game;
import View.IView;

public class PlayGame {
    public boolean Play(Game game, IView view) {
        view.DisplayWelcomeMessage();

        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

        if (game.IsGameOver()) {
            view.DisplayGameOver(game.IsDealerWinner());
        }

        if (view.play()) {
            game.NewGame();
        }
        else if (view.hit()) {
            game.Hit();
        }
        else if (view.stand()) {
            game.Stand();
        }

        return view.quit();
    }
}
