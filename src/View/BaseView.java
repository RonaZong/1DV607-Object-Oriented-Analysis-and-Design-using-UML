package View;

public abstract class BaseView implements Runnable{

    protected int getInput() {
        try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println(e);
            return 0;
        }
    }

    public boolean play() {
        return getInput() == 'p';
    }


    public boolean hit() {
        return getInput() == 'h';
    }

    public boolean stand() {
        return getInput() == 's';
    }

    public boolean quit() {
        return getInput() == 'q';
    }

}
