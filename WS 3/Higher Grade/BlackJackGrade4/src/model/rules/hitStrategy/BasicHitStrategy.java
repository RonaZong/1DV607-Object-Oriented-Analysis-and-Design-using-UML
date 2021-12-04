package model.rules.hitStrategy;

import model.Player;
import model.rules.IVisitor;

public class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //we have to add new rule here
    public boolean DoHit(Player a_dealer) {
        return a_dealer.CalcScore() < g_hitLimit;
    }
}