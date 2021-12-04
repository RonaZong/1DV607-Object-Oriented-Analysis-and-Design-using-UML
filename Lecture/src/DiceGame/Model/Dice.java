package DiceGame.Model;

public class Dice {

    private int value;

    public void roll() {
        value = (int) (Math.random() * 171717.0) % 6 + 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
