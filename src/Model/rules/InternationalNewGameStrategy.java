package Model.rules;

import Model.Dealer;
import Model.Deck;
import Model.Player;

class InternationalNewGameStrategy extends Factory implements NewGameStrategy {
    public boolean NewGame(Deck deck, Dealer dealer, Player player) {
        getCard(deck, player, true);
        getCard(deck, dealer, true);
        getCard(deck, player, true);

        return true;
    }
}
