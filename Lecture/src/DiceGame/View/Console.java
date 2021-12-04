package DiceGame.View;

public class Console extends BaseConsole implements IView {

    @Override
    public boolean wantsToPlay() {
        return getInputChar() != 'q';
    }

    @Override
    public void displayResult(boolean win) {
        if (win) {
            System.out.println("You win!");
        } else {
            System.out.println("Sorry, you lost...");
        }
    }

    public void displayWelcome() {
        System.out.println("Dice Game");
    }

    public void displayInstruction() {
        System.out.println("Press any key to play\n" + "Press 'q' to quit");
    }


}
