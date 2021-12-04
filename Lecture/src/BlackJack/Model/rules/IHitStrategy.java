package BlackJack.Model.rules;

import BlackJack.Model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
}
