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

    private Color color;
    private Value value;
    private boolean isHidden;

    public Card(Color color, Value value) {
        this.value = value;
        this.color = color;
        this.isHidden = true;
    }

    public Color GetColor() {
        if (this.isHidden) {
            return Color.Hidden;
        }
        return this.color;
    }

    public Value GetValue() {
        if (this.isHidden) {
            return Value.Hidden;
        }
        return this.value;
    }

    public void Show(boolean show) {
        this.isHidden = !show;
    }

}
