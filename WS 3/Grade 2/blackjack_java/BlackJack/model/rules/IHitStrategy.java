package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
//    boolean Soft17(Player a_dealer);

}