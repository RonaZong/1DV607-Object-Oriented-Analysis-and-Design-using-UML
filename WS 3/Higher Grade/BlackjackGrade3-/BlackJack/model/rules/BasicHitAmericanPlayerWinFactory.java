package BlackJack.model.rules;

import BlackJack.model.rules.hitStrategy.BasicHitStrategy;
import BlackJack.model.rules.hitStrategy.IHitStrategy;
import BlackJack.model.rules.newGameStartegy.AmericanNewGameStrategy;
import BlackJack.model.rules.newGameStartegy.INewGameStrategy;
import BlackJack.model.rules.newGameStartegy.InternationalNewGameStrategy;
import BlackJack.model.rules.winnerStrategy.IWinnerStrategy;
import BlackJack.model.rules.winnerStrategy.PlayerWinStrategy;

public class BasicHitAmericanPlayerWinFactory implements RulesAbstractFactory{
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
        return new PlayerWinStrategy();
    }
}
