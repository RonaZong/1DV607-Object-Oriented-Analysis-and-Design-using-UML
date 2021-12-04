package BlackJack.model.rules.hitStrategy;

import BlackJack.model.Card;
import BlackJack.model.Player;
import BlackJack.model.rules.IVisitor;
import BlackJack.model.rules.hitStrategy.IHitStrategy;

public class Soft17RuleStrategy implements IHitStrategy {

    @Override
    public boolean DoHit(Player a_dealer) {
       if(isSoft17(a_dealer)) {
           if(a_dealer.CalcScore() == 17) {
               return true;
           }
       }
           return a_dealer.CalcScore() <17;
    }

    private boolean isSoft17(Player a_dealer){

            for(Card c : a_dealer.GetHand()){
                if(c.GetValue() == Card.Value.Ace)
                    return true;
            }

        return false;
    }
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
