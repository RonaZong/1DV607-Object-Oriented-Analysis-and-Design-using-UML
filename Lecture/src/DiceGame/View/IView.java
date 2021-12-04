package DiceGame.View;

public interface IView {

    boolean wantsToPlay();
    void displayResult(boolean win);
    void displayWelcome();
    void displayInstruction();
}
