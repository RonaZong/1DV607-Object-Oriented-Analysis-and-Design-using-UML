package View;

import Model.Card;

public interface IView {
    boolean play();
    boolean hit();
    boolean stand();
    boolean quit();
    void collectEvents();
    void Pause();

    void DisplayWelcomeMessage();
    void DisplayPlayerCard(Card card);
    void DisplayDealerCard(Card card);
    void DisplayCard(String name, Card card);
    void DisplayPlayerHand(Iterable<Card> hand, int score);
    void DisplayDealerHand(Iterable<Card> hand, int score);
    void DisplayGameOver(boolean dealerIsWinner);
}

