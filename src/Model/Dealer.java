package Model;

import Model.rules.HitStrategy;
import Model.rules.IWinnerStrategy;
import Model.rules.NewGameStrategy;
import Model.rules.RulesFactory;

public class Dealer extends Player{
    private Deck deck;
    private Card card;
    private NewGameStrategy newGameStrategy;
    private HitStrategy hitStrategy;
    private IWinnerStrategy m_winner;

    public Dealer(RulesFactory rulesFactory) {
        /** AmericanNewGame */
        this.newGameStrategy = rulesFactory.GetNewGameRule();
        /** BasicHit */
        this.hitStrategy = rulesFactory.GetHitRule();
        m_winner = rulesFactory.GetWinner();

    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public boolean NewGame(Player player) {
        if (this.deck == null || IsGameOver()) {
            this.deck = new Deck(this.card);
            ClearHand();
            player.ClearHand();
            return newGameStrategy.NewGame(this.deck, this, player);
        }
        return false;
    }

    private void getCard(Player role) {
        this.card = this.deck.GetCard();
        card.Show(true);
        role.DealCard(card);
    }

    /** Take another card from the dealer */
    public boolean Hit(Player player) {
        if (this.deck != null && player.CalcScore() < this.maxScore && !IsGameOver()) {
            getCard(player);
            return true;
        }
        return false;
    }

    public boolean Stand() {
        /** Dealer gets card, Player stand */
        if (this.deck != null) {
            ShowHand();
            while (this.hitStrategy.DoHit(this)) {
                getCard(this);
            }
            return true;
        }
        else if (this.hitStrategy.Soft17(this))  {
            return false;
        }
        return false;
    }

    /** Dealer won */
    public boolean IsDealerWinner(Player player, Dealer dealer) {
        //    if (a_player.CalcScore() > g_maxScore) {
//      return true;
//    } else if (CalcScore() > g_maxScore) {
//      return false;
//    }
//    return CalcScore() >= a_player.CalcScore();
//    if (m_winner.IsPlayerWinner(a_player, a_dealer, g_maxScore)) {
//      return false; // player win
//    }
//    else
        if (m_winner.IsDealerWinner(player, dealer, maxScore)) {
            return true; // dealer win
        }

        return m_winner.GeneralWinner(player, dealer, maxScore);
    }

    /** Dealer Lost */
    public boolean IsGameOver() {
        return this.deck != null && !this.hitStrategy.DoHit(this); // dealer won
    }
}