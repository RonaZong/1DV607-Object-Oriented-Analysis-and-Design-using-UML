package model.rules;

import model.rules.hitStrategy.BasicHitStrategy;
import model.rules.hitStrategy.Soft17RuleStrategy;
import model.rules.newGameStartegy.AmericanNewGameStrategy;
import model.rules.newGameStartegy.InternationalNewGameStrategy;
import model.rules.winnerStrategy.DealerWinStrategy;
import model.rules.winnerStrategy.PlayerWinStrategy;

public interface IVisitor {
    void visit(AmericanNewGameStrategy americanNewGameStrategy);
    void visit(InternationalNewGameStrategy internationalNewGameStrategy);
    void visit(BasicHitStrategy basicHitStrategy);
    void visit(Soft17RuleStrategy Soft17RuleStrategy);
    void visit(DealerWinStrategy DealerWinStrategy);
    void visit(PlayerWinStrategy PlayerWinStrategy);
}

