package Model.rules;

import Model.Player;

public interface HitStrategy {
    boolean DoHit(Player dealer);
    boolean Soft17(Player dealer);
}
