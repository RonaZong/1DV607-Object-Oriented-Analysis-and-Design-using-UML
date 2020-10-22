package Model.rules;

import Model.Dealer;
import Model.Deck;
import Model.Player;

public interface NewGameStrategy {
    boolean NewGame(Deck deck, Dealer dealer, Player player);
}
