package BlackJack.model.rules.winnerStrategy;

import BlackJack.model.rules.IVisible;

public interface IWinnerStrategy extends IVisible {
    boolean isDealerWinner(int dealerCore, int playerScore, int maxScore);
}
