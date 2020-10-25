package Model.rules;


import Model.Dealer;
import Model.Player;

public class WinnerStrategy implements IWinnerStrategy{
    public boolean IsDealerWinner(Player a_player, Dealer a_dealer, final int g_maxScore) {
        System.out.println("a");
//        if (a_player.CalcScore() > g_maxScore) {
//            return true;
//        } else if (a_dealer.CalcScore() > g_maxScore) {
//            return false;
//        }
        return a_dealer.CalcScore() == a_player.CalcScore(); // dealer win
    }

    public boolean GeneralWinner(Player a_player, Dealer a_dealer, final int g_maxScore) {
        System.out.println("a");
        if (a_player.CalcScore() > g_maxScore) {
            return true; // player lose
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false; // player win
        }
        return a_dealer.CalcScore() > a_player.CalcScore(); // player win
    }
}
