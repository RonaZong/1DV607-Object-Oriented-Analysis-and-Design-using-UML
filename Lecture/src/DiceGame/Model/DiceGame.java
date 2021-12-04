package DiceGame.Model;

import java.util.ArrayList;

public class DiceGame {
    private Dice d1, d2, d3;
    private ArrayList<DiceRolledObserver> subscribers;

    public DiceGame() {
        d1 = new Dice();
        d2 = new Dice();
        d3 = new Dice();
        subscribers = new ArrayList<DiceRolledObserver>();
    }

    public void addSubscriber(DiceRolledObserver subscriber) {
        subscribers.add(subscriber);
    }

    private void rollDice(Dice dice) {
        dice.roll();
        for (DiceRolledObserver obs : subscribers) {
            obs.DiceRolled(dice.getValue());
        }

        // Delay
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }

    public boolean play() {
        rollDice(d1);
        rollDice(d2);
        rollDice(d3);

        return d1.getValue() + d2.getValue() + d3.getValue() == 9;
    }
}
