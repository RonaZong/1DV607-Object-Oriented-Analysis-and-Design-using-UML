package DiceGame.Controller;

import DiceGame.Model.DiceGame;
import DiceGame.Model.DiceRolledObserver;
import DiceGame.View.IView;

public class Player implements DiceRolledObserver {
    private IView view;

    public Player(IView iView) {
        this.view = iView;
    }

    public void playGame(DiceGame game) {

        game.addSubscriber(this);
        this.view.displayWelcome();
        this.view.displayInstruction();

        while (this.view.wantsToPlay()) {
            this.view.displayResult(game.play());

            this.view.displayInstruction();

        }

    }

    public void DiceRolled(int faceValue) {
        System.out.println(faceValue);
    }
}
