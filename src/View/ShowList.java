package View;

import java.util.Scanner;

public class ShowList {
    private Scanner sc = new Scanner(System.in);

    public ShowList() {
    }

    public void showInstruction(){
        System.out.println("----Show List----\n" +
                "Press 1 to show COMPACT LIST\n" +
                "Press 2 to show VERBOSE LIST\n" +
                "Press 3 to show SPECIFIC MEMBER\n" +
                "Press 0 to back to previous menu");
        int userInput = sc.nextInt();
    }


}
