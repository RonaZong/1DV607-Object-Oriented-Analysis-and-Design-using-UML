package DiceGame.View;

import java.io.IOException;

public abstract class BaseConsole {
    protected int getInputChar() {
        try {
            int c = System.in.read();
            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }
            return c;
        } catch (IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

}
