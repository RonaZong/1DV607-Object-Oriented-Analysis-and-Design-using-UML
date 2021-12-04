package model.rules.newGameStartegy;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;
import model.rules.newGameStartegy.INewGameStrategy;

public abstract class Factory implements INewGameStrategy {

    public boolean NewGame(Dealer a_dealer, Player a_player) {

        a_dealer.getCard(a_player, true);
        a_dealer.getCard(a_dealer, true);
        a_dealer.getCard(a_player, true);

    return true;
    }
}
