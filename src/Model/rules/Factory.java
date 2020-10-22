package Model.rules;

import Model.Card;
import Model.Deck;
import Model.Player;

public abstract class Factory {
    public void getCard(Deck deck, Player role, boolean show) {
        Card card = deck.GetCard();
        card.Show(show);
        role.DealCard(card);
    }
}
