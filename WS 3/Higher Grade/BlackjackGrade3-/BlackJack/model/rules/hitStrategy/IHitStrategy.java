package BlackJack.model.rules.hitStrategy;

import BlackJack.model.Player;
import BlackJack.model.rules.IVisible;

public interface IHitStrategy extends IVisible {
    boolean DoHit(Player a_dealer);
}