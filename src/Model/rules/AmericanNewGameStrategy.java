package Model.rules;

import Model.Card;
import Model.Dealer;
import Model.Deck;
import Model.Player;

class AmericanNewGameStrategy extends Factory implements NewGameStrategy {
    public boolean NewGame(Deck deck, Dealer dealer, Player player) {
//        Card c;

        /** Rona added */
        getCard(deck, player, true);
        getCard(deck, dealer, true);
        getCard(deck, player, true);
        getCard(deck, dealer, false);

//        c = deck.GetCard();
//        c.Show(true);
//        player.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(true);
//        dealer.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(true);
//        player.DealCard(c);
//
//        c = deck.GetCard();
//        c.Show(false);
//        dealer.DealCard(c);

        return true;
    }

}
