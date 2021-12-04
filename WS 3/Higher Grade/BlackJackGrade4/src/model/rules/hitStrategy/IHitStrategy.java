package model.rules.hitStrategy;

import model.Player;
import model.rules.IVisible;

public interface IHitStrategy extends IVisible {
    boolean DoHit(Player a_dealer);
}