package BlackJack.model.rules.newGameStartegy;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;
import BlackJack.model.rules.newGameStartegy.INewGameStrategy;

public abstract class Factory implements INewGameStrategy {

    public boolean NewGame(Dealer a_dealer, Player a_player) {

        a_dealer.getCard(a_player, true);
        a_dealer.getCard(a_dealer, true);
        a_dealer.getCard(a_player, true);

    return true;
    }
}
