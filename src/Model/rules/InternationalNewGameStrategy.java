package Model.rules;

import Model.Card;
import Model.Dealer;
import Model.Deck;
import Model.Player;

class InternationalNewGameStrategy implements NewGameStrategy {
    public boolean NewGame(Deck deck, Dealer dealer, Player a_player) {
        Card c;

        c = deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);

        c = deck.GetCard();
        c.Show(true);
        dealer.DealCard(c);

        c = deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);

        return true;
    }
}
