package SingletonPattern;

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {}

    /** Force every thread to wait its turn before it can enter the method */
    // to display card
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
