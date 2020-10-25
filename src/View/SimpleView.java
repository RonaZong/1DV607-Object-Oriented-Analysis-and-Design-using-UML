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

    public void DisplayCard(Card card) {
        System.out.println(card.GetValue() + " of " + card.GetColor());
    }

    public void DisplayPlayerCard() {
        System.out.print("Player: ");
    }

    public void DisplayDealerCard() {
        System.out.print("Dealer: ");
    }

    public void DisplayPlayerHand(Iterable<Card> hand, int score) {
        DisplayHand("Player", hand, score);
    }

    public void DisplayDealerHand(Iterable<Card> hand, int score) {
        DisplayHand("Dealer", hand, score);
    }

    private void DisplayHand(String name, Iterable<Card> hand, int score)
    {
        System.out.println(name + ": ");
        for(Card card : hand)
        {
            DisplayCard(card);
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

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("*pause*");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
