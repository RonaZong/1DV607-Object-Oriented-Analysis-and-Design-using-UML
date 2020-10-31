package view;

//import BlackJack.model.IGameObserver;

//extends IGameObserver
public interface IView
{
  void DisplayWelcomeMessage();
  void Pause();
  //I put into IBasicView
  //int GetInput();
  void DisplayCard(model.Card a_card);
  void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
    void collectEvents();
    boolean wantsToStartNewGame();
    boolean wantsToHit();
    boolean wantsToStand();
    boolean wantsToQuit();
}