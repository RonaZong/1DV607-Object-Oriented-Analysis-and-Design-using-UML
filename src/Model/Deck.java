package Model;

import java.util.LinkedList;
import java.util.List;

public class Deck implements CardObserver{
    private List<Card> cards;
    private Card card;

    private static int observerIDTracker = 0;
    private int observerID;


    public Deck(Card card) {
        this.cards = new LinkedList<Card>();
        this.card = card;

        for(int cIx = 0; cIx < Card.Value.Count.ordinal(); cIx++) {
            for (int vIx = 0; vIx < Card.Color.Count.ordinal(); vIx++) {
                this.card = new Card(Card.Value.values()[cIx], Card.Color.values()[vIx]);
                AddCard(this.card);
                this.observerID = ++observerIDTracker;
                System.out.println("New Observer " + this.observerID);
                card.register(this);
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

    @Override
    public void update(Card.Value cardValue, Card.Color cardColor) {
        this.card.GetValue() = cardValue;
        this.card.GetColor() = cardColor;

        printTheCard();
    }

    public void printTheCard() {
        System.out.println(observerID + "\n" + );
    }
}
