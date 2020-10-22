package Model;

import Model.rules.RulesFactory;

public class Game {
    private Dealer dealer;
    private Player player;

    public Game() {
        this.dealer = new Dealer(new RulesFactory());
        this.player = new Player();
    }

    public boolean IsGameOver() {
        return this.dealer.IsGameOver();
    }

    public boolean IsDealerWinner() {
        return this.dealer.IsDealerWinner(player);
    }

    public boolean NewGame() {
        return this.dealer.NewGame(player);
    }

    /** take a card */
    public boolean Hit() {
        return this.dealer.Hit(player);
    }

    /** end turn */
    public boolean Stand() {
        // TODO: Implement this according to Game_Stand.sequencediagram
        return this.dealer.Stand();
    }

    public Iterable<Card> GetDealerHand() {
        return this.dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand() {
        return this.player.GetHand();
    }

    public int GetDealerScore() {
        return this.dealer.CalcScore();
    }

    public int GetPlayerScore() {
        return this.player.CalcScore();
    }
}
