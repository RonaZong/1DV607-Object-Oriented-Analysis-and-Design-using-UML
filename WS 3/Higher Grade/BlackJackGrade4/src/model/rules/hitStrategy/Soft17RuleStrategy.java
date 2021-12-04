package model.rules.hitStrategy;

import model.Card;
import model.Player;
import model.rules.IVisitor;
import model.rules.hitStrategy.IHitStrategy;

public class Soft17RuleStrategy implements IHitStrategy {

    @Override
    public boolean DoHit(Player a_dealer) {
       if(isSoft17(a_dealer)) {
           if(a_dealer.CalcScore() == 17) {
               return true;
           }
       }
           return a_dealer.CalcScore() < 17;
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
