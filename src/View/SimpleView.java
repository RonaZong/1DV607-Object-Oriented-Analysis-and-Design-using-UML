package View;

import Model.Card;

public class SimpleView extends BaseView implements IView {

    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        System.out.println("Hello Black Jack World\n" +
                "Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }


    public void DisplayPlayerCard(Card card) {
        DisplayCard("Player", card);
    }

    public void DisplayDealerCard(Card card) {
        DisplayCard("Dealer", card);
    }

    public void DisplayCard(String name, Card card) {
        System.out.println(name + ": " + card.GetValue() + " of " + card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<Card> hand, int score) {
        DisplayHand("Player", hand, score);
    }

    public void DisplayDealerHand(Iterable<Card> hand, int score) {
        DisplayHand("Dealer", hand, score);
    }

    private void DisplayHand(String name, Iterable<Card> hand, int score)
    {
        for(Card card : hand)
        {
            DisplayCard(name, card);
        }
        System.out.println("Score: " + score + "\n");
    }


    public void DisplayGameOver(boolean dealerIsWinner) {
        System.out.println("GameOver: ");
        if (dealerIsWinner) {
            System.out.println("Dealer Won!");
        }
        else {
            System.out.println("You Won!");
        }
    }
}
