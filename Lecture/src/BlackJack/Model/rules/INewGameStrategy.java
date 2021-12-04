package BlackJack.Model.rules;

import BlackJack.Model.Dealer;
import BlackJack.Model.Deck;
import BlackJack.Model.Player;

public interface INewGameStrategy {
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}
