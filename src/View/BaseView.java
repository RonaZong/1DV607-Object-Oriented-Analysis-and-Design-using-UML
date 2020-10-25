package View;

public abstract class BaseView {
    private int input;

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

    public void collectEvents() {
        this.input = getInput();
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

    public void Pause() {
        try {
            Thread.sleep(2000);
            System.out.println("...");
        } catch (Exception e) {
        }
    }

}
