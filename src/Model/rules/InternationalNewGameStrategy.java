package Model.rules;

import Model.Card;
import Model.Dealer;
import Model.Deck;
import Model.Player;

class InternationalNewGameStrategy extends Factory implements NewGameStrategy {
    public boolean NewGame(Deck deck, Dealer dealer, Player player) {
        /** Rona added */
        getCard(deck, player, true);
        getCard(deck, dealer, true);
        getCard(deck, player, true);

//        Card c;
//
//        c = deck.GetCard();
//        c.Show(true);
//        a_player.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(true);
//        dealer.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(true);
//        a_player.DealCard(c);

        return true;
    }
}
