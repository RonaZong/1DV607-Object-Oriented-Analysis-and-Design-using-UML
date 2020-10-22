package View;

import Model.Card;

public class SimpleView extends BaseView implements IView{
    public boolean play() {
        return getInput() == 'q';
    }

    public boolean hit() {
        return getInput() == 'h';
    }

    public boolean stand() {
        return getInput() == 's';
    }

    public boolean quit() {
        return getInput() == 'q';
    }

    public void DisplayWelcomeMessage()
    {
//        for(int i = 0; i < 50; i++) {System.out.print("\n");};
        System.out.println("Hello Black Jack World\n" + "Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public void DisplayCard(Card card)
    {
        System.out.println("" + card.GetValue() + " of " + card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<Card> hand, int score)
    {
        DisplayHand("Player", hand, score);
    }

    public void DisplayDealerHand(Iterable<Card> hand, int score)
    {
        DisplayHand("Dealer", hand, score);
    }

    private void DisplayHand(String name, Iterable<Card> hand, int score)
    {
        System.out.println(name + " Has: ");
        for(Card c : hand)
        {
            DisplayCard(c);
        }
        System.out.println("Score: " + score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean dealerIsWinner)
    {
        System.out.println("GameOver: ");
        if (dealerIsWinner) {
            System.out.println("Dealer Won!");
        }
        else {
            System.out.println("You Won!");
        }
    }
}
