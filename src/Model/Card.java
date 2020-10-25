package Model;


public class Card {

    public enum Color {
        Hearts,
        Spades,
        Diamonds,
        Clubs,
        Count,
        Hidden
    }

    public enum Value {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Knight,
        Queen,
        King,
        Ace,
        Count,
        Hidden
    }

    private Value value;
    private Color color;
    private boolean isHidden;

    public Card(Value value, Color color) {
        this.value = value;
        this.color = color;
        this.isHidden = true;
    }

    public Value GetValue() {
        if (this.isHidden) {
            return Value.Hidden;
        }
        return this.value;
    }

    public Color GetColor() {
        if (this.isHidden) {
            return Color.Hidden;
        }
        return this.color;
    }

    public void Show(boolean show) {
        this.isHidden = !show;
    }


}
