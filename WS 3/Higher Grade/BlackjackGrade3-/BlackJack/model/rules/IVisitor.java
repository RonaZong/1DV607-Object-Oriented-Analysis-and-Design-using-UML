package BlackJack.model.rules;

import BlackJack.model.rules.hitStrategy.BasicHitStrategy;
import BlackJack.model.rules.hitStrategy.Soft17RuleStrategy;
import BlackJack.model.rules.newGameStartegy.AmericanNewGameStrategy;
import BlackJack.model.rules.newGameStartegy.InternationalNewGameStrategy;
import BlackJack.model.rules.winnerStrategy.DealerWinStrategy;
import BlackJack.model.rules.winnerStrategy.PlayerWinStrategy;

public interface IVisitor {
    void visit(AmericanNewGameStrategy americanNewGameStrategy);
    void visit(InternationalNewGameStrategy internationalNewGameStrategy);
    void visit(BasicHitStrategy basicHitStrategy);
    void visit(Soft17RuleStrategy Soft17RuleStrategy);
    void visit(DealerWinStrategy DealerWinStrategy);
    void visit(PlayerWinStrategy PlayerWinStrategy);

}

