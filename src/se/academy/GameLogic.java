package se.academy;

import java.util.Iterator;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class GameLogic {

    private static void craschAlternatives(Ship ship, SpaceObject spaceObject) {
        if (spaceObject.willKillShip) {
            System.exit(0);
        }
        if (spaceObject.willMakeShipBigger) {
            ship.makeShipBigger();
        }
        if (spaceObject.willMakeShipSmaller) {
            ship.makeShipSmaller();
            //Alternativ för när ship crascher med de olika Spaceobjekten.
        }
    }

    public static void findAndHandleCrasch(World world) {
        for (Iterator<SpaceObject> iterator = world.itemsInWorld.iterator(); iterator.hasNext(); ) {
            SpaceObject spaceobject = iterator.next();
            if (ShipamePositionAsSpaceObject(world.ship, spaceobject)) {
                craschAlternatives(world.ship, spaceobject);
                iterator.remove();
                break;
            }
        }
        // Om ship är på samma plats som Spaceobject --> aktivera craschAlternatives.
    }


    private static boolean ShipamePositionAsSpaceObject(Ship ship, SpaceObject spaceObject) {
        for (Point point : ship.generateListOfPointInShip()) {
            if (spaceObject.x == point.x && spaceObject.y == point.y) {
                return true;
                // När ship är på samma position som SpaceObject (vilket som).
            }
        }
        return false;

    }
}
