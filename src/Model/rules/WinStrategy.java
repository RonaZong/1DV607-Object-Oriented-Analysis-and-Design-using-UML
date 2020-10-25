package Model.rules;

import Model.Dealer;
import Model.Player;

public interface WinStrategy {
    boolean IsPlayerWinner(Player player, Dealer dealer, final int maxScore);
    boolean IsDealerWinner(Player player, Dealer dealer, final int maxScore);
}
