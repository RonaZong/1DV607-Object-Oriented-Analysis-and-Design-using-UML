package BlackJack.Model.rules;

import BlackJack.Model.Card;
import BlackJack.Model.Dealer;
import BlackJack.Model.Deck;
import BlackJack.Model.Player;

class AmericanNewGameStrategy implements INewGameStrategy{
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

        c = a_deck.GetCard();
        c.Show(false);
        a_dealer.DealCard(c);

        return true;
    }
}
