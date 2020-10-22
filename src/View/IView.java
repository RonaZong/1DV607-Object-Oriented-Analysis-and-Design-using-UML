package View;

import Model.Card;
import Model.Dealer;

import java.util.Scanner;

public interface IView {
    boolean play();
    boolean hit();
    boolean stand();
    boolean quit();
    void DisplayWelcomeMessage();
    void DisplayCard(Card card);
    void DisplayPlayerHand(Iterable<Card> hand, int score);
    void DisplayDealerHand(Iterable<Card> hand, int score);
    void DisplayGameOver(boolean dealerIsWinner);
}

