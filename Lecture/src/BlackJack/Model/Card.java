package BlackJack.Model;

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

    private Color m_color;
    private Value m_value;
    private boolean m_isHidden;

    public Card(Color m_color, Value m_value) {
        this.m_color = m_color;
        this.m_value = m_value;
        m_isHidden = true;
    }

    public Color GetColor() {
        if (m_isHidden)
        {
            return Color.Hidden;
        }
        return m_color;
    }

    public Value GetValue() {
        if (m_isHidden)
        {
            return Value.Hidden;
        }
        return m_value;
    }

    public void Show(boolean a_show) {
        m_isHidden = !a_show;
    }

}
