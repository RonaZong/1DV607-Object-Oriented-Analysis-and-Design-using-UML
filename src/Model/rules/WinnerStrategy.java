package Model.rules;


import Model.Dealer;
import Model.Player;

public class WinnerStrategy implements WinStrategy {
    public boolean IsPlayerWinner(Player player, Dealer dealer, final int maxScore) {
        if (player.CalcScore() > maxScore) {
            return true;
        } else if (dealer.CalcScore() > maxScore) {
            return false;
        }
        return player.CalcScore() >= dealer.CalcScore();
    }

    public boolean IsDealerWinner(Player player, Dealer dealer, final int maxScore) {
        if (player.CalcScore() > maxScore) {
            return true; // player lose
        } else if (dealer.CalcScore() > maxScore) {
            return false; // player win
        }
        return dealer.CalcScore() >= player.CalcScore(); // player win
    }
}
