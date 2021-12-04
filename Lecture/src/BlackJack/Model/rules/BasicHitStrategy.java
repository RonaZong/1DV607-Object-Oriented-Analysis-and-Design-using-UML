package BlackJack.Model.rules;

import BlackJack.Model.Player;

public class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        return a_dealer.CalcScore() < g_hitLimit;
    }
}