package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.BasicHitAmericanGameDealerWinFactory;
import BlackJack.model.rules.IVisible;
import BlackJack.model.rules.IVisitor;

import BlackJack.model.rules.RulesAbstractFactory;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
    PrintVisitor printVisitor = new PrintVisitor();
    RulesAbstractFactory factory = new BasicHitAmericanGameDealerWinFactory();
  //  Game g = new Game(printVisitor);
    Game g = new Game(factory,printVisitor);
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame(v,g);
    g.SubscriptionToNewCards(ctrl);
    while (ctrl.Play());
  }
}