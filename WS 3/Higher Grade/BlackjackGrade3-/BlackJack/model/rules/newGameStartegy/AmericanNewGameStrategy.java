package BlackJack.model.rules.newGameStartegy;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.rules.IVisitor;

public class AmericanNewGameStrategy extends Factory {
  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }

  public boolean NewGame(Dealer a_dealer, Player a_player) {

    super.NewGame(a_dealer,a_player);
    a_dealer.getCard(a_dealer, false);

    return true;
  }
}