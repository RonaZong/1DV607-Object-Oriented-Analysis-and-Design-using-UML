package Model;

import Model.rules.IHitStrategy;
import Model.rules.INewGameStrategy;
import Model.rules.RulesFactory;

public class Dealer extends Player{
    private Deck deck;
    private INewGameStrategy newGameStrategy;
    private IHitStrategy hitStrategy;

    public Dealer(RulesFactory a_rulesFactory) {

        newGameStrategy = a_rulesFactory.GetNewGameRule();
        hitStrategy = a_rulesFactory.GetHitRule();

    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
    }


    public boolean NewGame(Player a_player) {
        if (deck == null || IsGameOver()) {
            deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return newGameStrategy.NewGame(deck, this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            Card c;
            c = deck.GetCard();
            c.Show(true);
            a_player.DealCard(c);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (CalcScore() > g_maxScore) {
            return false;
        }
        return CalcScore() >= a_player.CalcScore();
    }

    public boolean IsGameOver() {
        if (deck != null && hitStrategy.DoHit(this) != true) {
            return true;
        }
        return false;
    }
}
