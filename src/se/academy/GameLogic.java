package se.academy;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class GameLogic {

    private static void craschAlternatives(Ship ship, SpaceObject spaceObject, Screen screen, Score score) throws InterruptedException {
        if (spaceObject.willKillShip) {
            screen.printText("Game over noob!");
            Thread.sleep(2000);
            screen.printText("Your score: " + score.getScore());
            Thread.sleep(2000);
            screen.closeScreen();
            Scanner in = new Scanner(System.in);
            System.out.print("Enter name :");
            String name = in.nextLine();
            score.setName(name);
            score.addToHighScore();
            StartMeny.createStartMeny(new TerminalScreen(), new World());
        }
        if (spaceObject.willMakeShipBigger) {
            ship.makeShipBigger();
            score.addToScore(3);

        }
        if (spaceObject.willMakeShipSmaller) {
            ship.makeShipSmaller();
            score.subtractFromScore(1);
            //Alternativ för när ship crascher med de olika Spaceobjekten.
        }
    }

    public static void findAndHandleCrasch(World world, Screen screen, Score score) throws InterruptedException {
        for (Iterator<SpaceObject> iterator = world.itemsInWorld.iterator(); iterator.hasNext(); ) {
            SpaceObject spaceobject = iterator.next();
            if (ShipamePositionAsSpaceObject(world.ship, spaceobject)) {
                craschAlternatives(world.ship, spaceobject, screen, score);
                iterator.remove();
                break;
            }
        }
        // Om ship är på samma plats som Spaceobject --> aktivera craschAlternatives.
    }


    private static boolean ShipamePositionAsSpaceObject(Ship ship, SpaceObject spaceObject) {
        for (Point point : ship.generateListOfPointInShip()) {
            if (spaceObject.getxCoordinate() == point.getxCoordinate() && spaceObject.getyCoordinate() == point.getyCoordinate()) {
                return true;
                // När ship är på samma position som SpaceObject (vilket som).
            }
        }
        return false;

    }

}
