package View;

import Model.Card;

public interface IView {
    boolean play();
    boolean hit();
    boolean stand();
    boolean quit();
    void run();

    void DisplayWelcomeMessage();
    void DisplayCard(Card card);
    void DisplayPlayerCard();
    void DisplayDealerCard();
    void DisplayPlayerHand(Iterable<Card> hand, int score);
    void DisplayDealerHand(Iterable<Card> hand, int score);
    void DisplayGameOver(boolean dealerIsWinner);

}

