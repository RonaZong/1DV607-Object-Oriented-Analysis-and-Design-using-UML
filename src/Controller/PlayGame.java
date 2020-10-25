package Controller;

import Model.*;
import View.IView;

public class PlayGame implements CardObserver {
    private Game game;
    private IView view;

    public PlayGame(Game game, IView view) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void updateNewCard(Card card) {
        this.view.DisplayPlayerCard(card);
        this.view.Pause();
        this.view.DisplayDealerCard(card);

    }

    @Override
    public void GotCard(String name, Card.Value cardValue, Card.Color cardColor) {
        System.out.println(name + ": " + cardValue + " of " + cardColor);
    }

    public boolean Play() {
        this.view.DisplayWelcomeMessage();

        this.view.DisplayDealerHand(this.game.GetDealerHand(), this.game.GetDealerScore());
        this.view.DisplayPlayerHand(this.game.GetPlayerHand(), this.game.GetPlayerScore());

        if (this.game.IsGameOver()) {
            this.view.DisplayGameOver(this.game.IsDealerWinner());
        }

        this.view.collectEvents();

        if (this.view.play()) {
            this.game.NewGame();
        } else if (this.view.hit()) {
            this.game.Hit();
        } else if (this.view.stand()) {
            this.game.Stand();
        }

//        for (int i = 0; i <= ((Collection<?>) this.game.GetPlayerHand()).size(); i++) {
//            for (int k = 0; k <= ((Collection<?>) this.game.GetDealerHand()).size(); k++) {
//                this.game.GetPlayerCard(i);
//                this.game.GetDealerCard(k);
//            }
//        }

        return !this.view.quit();
    }
}
