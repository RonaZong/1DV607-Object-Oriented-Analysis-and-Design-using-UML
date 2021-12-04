package BlackJack.model.rules.newGameStartegy;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.rules.IVisible;

public interface INewGameStrategy extends IVisible {
    boolean NewGame(Dealer a_dealer, Player a_player);
}