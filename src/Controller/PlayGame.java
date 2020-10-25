package Controller;

import Model.*;
import View.IView;

public class PlayGame implements CardObserver {
    private Game game;
    private IView view;

    public PlayGame(Game game, IView view) {
        this.game = game;
        this.view = view;
        this.game.register(this);
    }

    @Override
    public void update(Card card) {
        this.view.DisplayCard(card);
        this.view.run();
    }

    public boolean Play() {
        this.view.DisplayWelcomeMessage();

        this.view.DisplayPlayerHand(this.game.GetPlayerHand(), this.game.GetPlayerScore());
        this.view.DisplayDealerHand(this.game.GetDealerHand(), this.game.GetDealerScore());

        if (this.game.IsGameOver()) {
            this.view.DisplayGameOver(this.game.IsDealerWinner());
        }

        if (this.view.play()) {
            this.game.NewGame();
        } else if (this.view.hit()) {
            this.game.Hit();
        } else if (this.view.stand()) {
            this.game.Stand();
        }

        return !this.view.quit();
    }


}
