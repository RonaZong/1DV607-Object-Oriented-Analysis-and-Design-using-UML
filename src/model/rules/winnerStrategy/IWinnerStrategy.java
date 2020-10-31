package model.rules.winnerStrategy;

import model.rules.IVisible;

public interface IWinnerStrategy extends IVisible {
    boolean isDealerWinner(int dealerCore, int playerScore, int maxScore);
}
