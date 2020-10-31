package model.rules.newGameStartegy;

import model.Deck;
import model.Dealer;
import model.Player;
import model.rules.IVisible;

public interface INewGameStrategy extends IVisible {
    boolean NewGame(Dealer a_dealer, Player a_player);
}