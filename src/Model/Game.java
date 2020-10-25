package Model;

import Model.rules.RulesFactory;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Player player;
    private Dealer dealer;

    public Game() {
        this.player = new Player();
        this.dealer = new Dealer(new RulesFactory());
    }

    public void register(CardObserver observer) {
        this.player.register(observer);
        this.dealer.register(observer);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public boolean NewGame() {
        return this.dealer.NewGame(this.player);
    }

    /** take a card */
    public boolean Hit() {
        return this.dealer.Hit(this.player);
    }

    /** end turn */
    public boolean Stand() {
        // TODO: Implement this according to Game_Stand.sequencediagram
        return this.dealer.Stand();
    }

    public boolean IsGameOver() {
        return this.dealer.IsGameOver();
    }

    public boolean IsDealerWinner() {
        return this.dealer.IsDealerWinner(this.player, this.dealer);
    }

    public Iterable<Card> GetPlayerHand() {
        return this.player.GetHand();
    }

    public Iterable<Card> GetDealerHand() {
        return this.dealer.GetHand();
    }

    public int GetPlayerScore() {
        return this.player.CalcScore();
    }

    public int GetDealerScore() {
        return this.dealer.CalcScore();
    }
}
