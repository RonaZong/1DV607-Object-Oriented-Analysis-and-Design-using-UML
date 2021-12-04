package BlackJack.model.rules.newGameStartegy;

import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;
import BlackJack.model.rules.IVisitor;

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