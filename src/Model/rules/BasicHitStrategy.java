package Model.rules;

import Model.Card;
import Model.Player;

public class BasicHitStrategy implements HitStrategy {
    private final int hitLimit = 17;

    // we have to add new rules
    // when dealer should take one more card
    public boolean DoHit(Player dealer) {
        return dealer.CalcScore() < this.hitLimit;
    }

    public boolean Soft17(Player dealer) {
        for(Card card : dealer.GetHand()) {
            return card.GetValue() == Card.Value.Ace && dealer.CalcScore() == this.hitLimit;
        }
        return false;
    }
}
