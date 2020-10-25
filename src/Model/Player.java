package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player  {
    private List<Card> hand;
    protected final int maxScore = 21;

    public Player() {
        this.hand = new LinkedList<Card>();
    }

    public void DealCard(Card addToHand) {
        this.hand.add(addToHand);
    }

    public Iterable<Card> GetHand() {
        return this.hand;
    }

    public void ClearHand() {
        this.hand.clear();
    }

    public void ShowHand() {
        for(Card c : GetHand()) {
            c.Show(true);
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
            for(Card c : GetHand()) {
                if (c.GetValue() == Card.Value.Ace && score > this.maxScore) {
                    score -= 10;
                }
            }
        }

        return score;
    }

    public boolean Soft17() {
        int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11 };
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

        int score = 0;

        for (Card card : GetHand()) {
            if (card.GetValue() == Card.Value.Ace) {
                score += cardScores[card.GetValue().ordinal()];

                if (score > this.maxScore) {
                    score -= 10;
                }
                return score == 17;
            }
        }

        return false;
    }


}
