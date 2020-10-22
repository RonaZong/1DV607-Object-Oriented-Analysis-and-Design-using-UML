package View;

import Model.Card;
import Model.Dealer;

import java.util.Scanner;

public interface IView {
    void DisplayWelcomeMessage();
    int GetInput();
    void DisplayCard(Card a_card);
    void DisplayPlayerHand(Iterable<Card> a_hand, int a_score);
    void DisplayDealerHand(Iterable<Card> a_hand, int a_score);
    void DisplayGameOver(boolean a_dealerIsWinner);
}

