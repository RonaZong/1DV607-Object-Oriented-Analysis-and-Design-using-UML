package BlackJack.model.rules;

import BlackJack.model.rules.hitStrategy.IHitStrategy;
import BlackJack.model.rules.newGameStartegy.INewGameStrategy;
import BlackJack.model.rules.winnerStrategy.IWinnerStrategy;

public interface RulesAbstractFactory {



  public IHitStrategy GetHitRule();

  public INewGameStrategy GetNewGameRule();

  public IWinnerStrategy GetWinnerStrategy();


}