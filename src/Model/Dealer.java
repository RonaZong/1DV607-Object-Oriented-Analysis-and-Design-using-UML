package Model;

import Model.rules.HitStrategy;
import Model.rules.NewGameStrategy;
import Model.rules.RulesFactory;

public class Dealer extends Player{
    private Deck deck;
    private NewGameStrategy newGameStrategy;
    private HitStrategy hitStrategy;

    public Dealer(RulesFactory rulesFactory) {
        /** AmericanNewGame */
        newGameStrategy = rulesFactory.GetNewGameRule();
        /** BasicHit */
        hitStrategy = rulesFactory.GetHitRule();

    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
    }


    public boolean NewGame(Player player) {
        if (deck == null || IsGameOver()) {
            deck = new Deck();
            ClearHand();
            player.ClearHand();
            return newGameStrategy.NewGame(deck, this, player);
        }
        return false;
    }

    /** Take another card from the dealer */
    public boolean Hit(Player player) {
        if (deck != null && player.CalcScore() < maxScore && !IsGameOver()) {
            Card c;
            c = deck.GetCard();
            c.Show(true);
            player.DealCard(c);

            return true;
        }
        return false;
    }

    /** Take no more cards */
    public boolean Stand() {
        if (deck != null) {
            ShowHand();

            while (hitStrategy.DoHit(this)) {
                Card c = deck.GetCard();
                c.Show(true);
                DealCard(c);
            }
            return true;
        }
        return false;
    }

    /** Dealer won */
    public boolean IsDealerWinner(Player player) {
        if (player.CalcScore() > maxScore) {
            return true; // dealer won
        } else if (CalcScore() > maxScore) {
            return false; // dealer lost
        }
        return CalcScore() >= player.CalcScore();
    }

    /** Dealer Lost */
    public boolean IsGameOver() {
        if (deck != null && hitStrategy.DoHit(this) != true) {
            return true;
        }
        return false;
    }
}
