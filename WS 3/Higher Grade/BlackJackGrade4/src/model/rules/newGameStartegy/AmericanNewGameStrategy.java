package model.rules.newGameStartegy;

import model.Deck;
import model.Dealer;
import model.Player;
import model.rules.IVisitor;

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