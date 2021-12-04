package model.rules;

import model.rules.hitStrategy.BasicHitStrategy;
import model.rules.hitStrategy.IHitStrategy;
import model.rules.hitStrategy.Soft17RuleStrategy;
import model.rules.newGameStartegy.AmericanNewGameStrategy;
import model.rules.newGameStartegy.INewGameStrategy;
import model.rules.winnerStrategy.DealerWinStrategy;
import model.rules.winnerStrategy.IWinnerStrategy;
import model.rules.winnerStrategy.PlayerWinStrategy;

public class BasicHitAmericanGameDealerWinFactory implements RulesAbstractFactory{
    @Override
    public IHitStrategy GetHitRule() {
        return new BasicHitStrategy();
    }

    @Override
    public INewGameStrategy GetNewGameRule() {
        return new AmericanNewGameStrategy();
    }

    @Override
    public IWinnerStrategy GetWinnerStrategy() {
        return new DealerWinStrategy();
    }
}
