package Model.rules;

import Model.Player;

public class BasicHitStrategy implements HitStrategy {
    /** Soft 17 */
    private final int hitLimit = 17;

    // we have to add new rules
    // when dealer should take one more card
    public boolean DoHit(Player dealer) {
        return dealer.CalcScore() < hitLimit;
    }

    public boolean Soft17(Player dealer) {
        if (dealer.Soft17()) {
            return dealer.CalcScore() == hitLimit;
        }
        return false;
    }
}
