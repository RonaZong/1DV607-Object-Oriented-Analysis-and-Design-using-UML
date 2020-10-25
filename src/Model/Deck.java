package Model;

import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new LinkedList<Card>();

        for(int cIx = 0; cIx < Card.Value.Count.ordinal(); cIx++) {
            for (int vIx = 0; vIx < Card.Color.Count.ordinal(); vIx++) {
                Card card = new Card(Card.Value.values()[cIx], Card.Color.values()[vIx]);
                AddCard(card);
            }
        }

        Shuffle();
    }

    public Iterable<Card> GetCards() {
        return this.cards;
    }

    public void AddCard(Card cardToAdd) {
        this.cards.add(cardToAdd);
    }

    public Card GetCard() {
        Card card = this.cards.get(0);
        this.cards.remove(0);

        return card;
    }

    private void Shuffle() {
        for (int i = 0; i < 1017; i++) {
            int index = (int)(Math.random() * 171717.0) % this.cards.size();
            Card c = this.cards.get(index);
            this.cards.remove(index);
            AddCard(c);
        }
    }


}
