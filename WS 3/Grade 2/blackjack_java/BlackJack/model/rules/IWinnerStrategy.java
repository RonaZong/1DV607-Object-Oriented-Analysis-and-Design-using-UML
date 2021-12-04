package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinnerStrategy {
    boolean isDealerWinner(int dealerCore, int playerScore,int maxScore);

//    boolean IsDealerWinner(Player a_player, Dealer a_dealer,  final int g_maxScore);
//    boolean IsPlayerWinner(Player a_player, Dealer a_dealer, final int g_maxScore);
//    boolean GeneralWinner(Player a_player, Dealer a_dealer, final int g_maxScore);
}
