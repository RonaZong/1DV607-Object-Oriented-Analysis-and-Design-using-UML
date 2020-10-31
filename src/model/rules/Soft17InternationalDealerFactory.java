package model.rules;

import model.rules.hitStrategy.IHitStrategy;
import model.rules.hitStrategy.Soft17RuleStrategy;
import model.rules.newGameStartegy.AmericanNewGameStrategy;
import model.rules.newGameStartegy.INewGameStrategy;
import model.rules.newGameStartegy.InternationalNewGameStrategy;
import model.rules.winnerStrategy.DealerWinStrategy;
import model.rules.winnerStrategy.IWinnerStrategy;

public class Soft17InternationalDealerFactory implements RulesAbstractFactory {
    @Override
    public IHitStrategy GetHitRule() {
        return new Soft17RuleStrategy();
    }

    @Override
    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    @Override
    public IWinnerStrategy GetWinnerStrategy() {
        return new DealerWinStrategy();
    }
}
