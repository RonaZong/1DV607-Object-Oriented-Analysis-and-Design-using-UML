package model.rules.newGameStartegy;

import model.Dealer;
import model.Deck;
import model.Player;
import model.rules.IVisitor;

public class InternationalNewGameStrategy extends Factory {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean NewGame(Dealer a_dealer, Player a_player) {
        super.NewGame(a_dealer,a_player);
        return false;
    }
}