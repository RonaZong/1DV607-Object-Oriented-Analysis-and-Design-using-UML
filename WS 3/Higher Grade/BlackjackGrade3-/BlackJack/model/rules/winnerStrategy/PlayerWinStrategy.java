package BlackJack.model.rules.winnerStrategy;

import BlackJack.model.rules.IVisitor;
import BlackJack.model.rules.winnerStrategy.IWinnerStrategy;

public class PlayerWinStrategy implements IWinnerStrategy {
    @Override
    public boolean isDealerWinner(int dealerCore, int playerScore, int maxScore) {

        if (playerScore > maxScore) {
      return true;
    } else if (dealerCore > maxScore) {
      return false;
    }
    return dealerCore > playerScore;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
