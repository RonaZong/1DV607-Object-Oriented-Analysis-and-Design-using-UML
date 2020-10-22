package Model.rules;

import Model.Card;
import Model.Dealer;
import Model.Deck;
import Model.Player;

class InternationalNewGameStrategy implements INewGameStrategy{
    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        Card c;

        c = a_deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);

        c = a_deck.GetCard();
        c.Show(true);
        a_dealer.DealCard(c);

        c = a_deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);

        return true;
    }
}
