package Model;


import java.util.ArrayList;

public class Card implements CardSubject{

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
    private ArrayList<CardObserver> observers;

    public Card(Value value, Color color) {
        this.value = value;
        this.color = color;
        this.isHidden = true;
        this.observers = new ArrayList<CardObserver>();

    }

    @Override
    public void register(CardObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(CardObserver deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex + 1) + " deleted");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (CardObserver observer : observers) {
            observer.update(this.value, this.color);
        }

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
