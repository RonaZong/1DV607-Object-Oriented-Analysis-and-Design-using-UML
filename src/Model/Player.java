package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player implements CardSubject{
    private List<Card> hand;
    protected final int maxScore = 21;
    private ArrayList<CardObserver> observers;

    public Player() {
        this.hand = new LinkedList<Card>();
        this.observers = new ArrayList<CardObserver>();
    }

    public void DealCard(Card addToHand) {
        this.hand.add(addToHand);
        notifyObserver(addToHand);
    }

    public Iterable<Card> GetHand() {
        return (LinkedList<Card>) this.hand;
    }

    public void ClearHand() {
        this.hand.clear();
    }

    public void ShowHand() {
        for(Card card : GetHand()) {
            card.Show(true);
        }
    }

    public int CalcScore() {
        // the number of scores is dependant on the number of scorable values
        // as it seems there is no way to do this check at compile time in java ?!
        // cardScores[13] = {...};
        int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11 };
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

        int score = 0;

        for(Card c : GetHand()) {
            if (c.GetValue() != Card.Value.Hidden) {
                score += cardScores[c.GetValue().ordinal()];
            }
        }

        if (score > this.maxScore) {
            for(Card card : GetHand()) {
                if (card.GetValue() == Card.Value.Ace && score > this.maxScore) {
                    score -= 10;
                }
            }
        }

        return score;
    }

    @Override
    public void register(CardObserver newObserver) {
        if (!observers.contains(newObserver)) {
            observers.add(newObserver);
        }
    }

    @Override
    public void unregister(CardObserver deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex + 1) + " deleted");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(Card card) {
        for (CardObserver observer : observers) {
            observer.update(card);
        }
    }

}
