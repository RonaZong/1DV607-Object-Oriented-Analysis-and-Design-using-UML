package Model;

public interface CardSubject {
    void register(CardObserver o);
    void unregister(CardObserver o);
    void notifyObserver(Card card);

}
