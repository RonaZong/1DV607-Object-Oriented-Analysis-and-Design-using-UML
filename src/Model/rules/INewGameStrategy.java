package Model.rules;

import Model.Dealer;
import Model.Deck;
import Model.Player;

public interface INewGameStrategy {
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}
