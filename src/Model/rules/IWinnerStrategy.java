package Model.rules;

import Model.Dealer;
import Model.Player;

public interface IWinnerStrategy {
    boolean IsDealerWinner(Player a_player, Dealer a_dealer, final int g_maxScore);
//    boolean IsPlayerWinner(Player a_player, Dealer a_dealer, final int g_maxScore);
    boolean GeneralWinner(Player a_player, Dealer a_dealer, final int g_maxScore);
}
