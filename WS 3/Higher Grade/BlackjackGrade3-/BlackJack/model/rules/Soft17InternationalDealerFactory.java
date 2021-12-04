package BlackJack.model.rules;

import BlackJack.model.rules.hitStrategy.IHitStrategy;
import BlackJack.model.rules.hitStrategy.Soft17RuleStrategy;
import BlackJack.model.rules.newGameStartegy.AmericanNewGameStrategy;
import BlackJack.model.rules.newGameStartegy.INewGameStrategy;
import BlackJack.model.rules.newGameStartegy.InternationalNewGameStrategy;
import BlackJack.model.rules.winnerStrategy.DealerWinStrategy;
import BlackJack.model.rules.winnerStrategy.IWinnerStrategy;

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
