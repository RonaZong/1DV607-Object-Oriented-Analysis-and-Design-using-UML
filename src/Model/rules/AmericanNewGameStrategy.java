package Model.rules;

import Model.Card;
import Model.Dealer;
import Model.Deck;
import Model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {
    public boolean NewGame(Deck deck, Dealer dealer, Player player) {
        Card c;

        c = deck.GetCard();
        c.Show(true);
        player.DealCard(c);

        c = deck.GetCard();
        c.Show(true);
        dealer.DealCard(c);

        c = deck.GetCard();
        c.Show(true);
        player.DealCard(c);

        c = deck.GetCard();
        c.Show(false);
        dealer.DealCard(c);

        return true;
    }


}
