package Example1_EnemyShip;

import java.util.Scanner;

public class EnemyShipTesting {
    public static void main(String[] args) {
        EnemyShipBuilding MakeUPOs = new EnemyShipBuilding();

        EnemyShipFactory shipFactory = new EnemyShipFactory();

        EnemyShip theGrunt = MakeUPOs.orderTheShip("UFO");
        System.out.println(theGrunt + "\n");

        EnemyShip theBoss = MakeUPOs.orderTheShip("UFO Boss");
        System.out.println(theBoss + "\n");

        Scanner userInput = new Scanner(System.in);

        System.out.println("What type of ship? (U / R / B)");

        if (userInput.hasNextLine()) {
            String typrOfShip = userInput.nextLine();
            theEnemy = shipFactory.makeEnemyShip(typrOfShip);
            if (theEnemy != null) {
                doStuffEnemy(theEnemy);
            }
            else {
                System.out.println("Please enter U, R, or B next time");
            }
        }
    }
}
