package model.rules;

import model.rules.hitStrategy.IHitStrategy;
import model.rules.newGameStartegy.INewGameStrategy;
import model.rules.winnerStrategy.IWinnerStrategy;

public interface RulesAbstractFactory {



  public IHitStrategy GetHitRule();

  public INewGameStrategy GetNewGameRule();

  public IWinnerStrategy GetWinnerStrategy();


}