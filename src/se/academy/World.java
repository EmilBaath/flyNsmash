package se.academy;

import com.googlecode.lanterna.input.Key;

import java.util.*;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class World {

    List<SpaceObject> objectsInWorld = new ArrayList<>(); // Lista med SpaceObjekt i world.
    private Random generator = new Random();
    Ship ship = new Ship();
    boolean gameOver = false;


    public void updateWorld(Screen screen, boolean updateObjects) {
        if (updateObjects) {
            movingItemsInWorld(screen);
            addSpaceObject(screen);
        }
        moveShip(screen);
    }

    private void movingItemsInWorld(Screen screen) {
        for (Iterator<SpaceObject> iterator = objectsInWorld.iterator(); iterator.hasNext(); ) {
            SpaceObject spaceObject = iterator.next();
            // Iterator behövs för att kunna ta bort element i listan.

            if (spaceObject.getyCoordinate()  >= screen.numberOfRows() - 1) {
                iterator.remove();
                // Tar bort object när de har kommit till botten.
            } else {
                spaceObject.fall();
                //Flyttar alla SpaceObjects neråt.

            }

        }
    }

    private void addSpaceObject(Screen screen) {
        int randomNumber = generator.nextInt(3);
        switch (randomNumber) {
            case 0:
                objectsInWorld.add(new Stone(screen));
                break;
            case 1:
                objectsInWorld.add(new Plus(screen));
                break;
            case 2:
                objectsInWorld.add(new Minus(screen));
                break;
            // genererar alla stenar, + och - slumpmässigt.
        }
    }

    private void craschAlternatives(SpaceObject spaceObject, Screen screen, Score score) throws InterruptedException {
        if (spaceObject.willKillShip) {
            gameOver = true;
        }
        if (spaceObject.willMakeShipBigger) {
            ship.makeShipBigger();
            score.addToScore(3);

        }
        if (spaceObject.willMakeShipSmaller) {
            ship.makeShipSmaller();
            score.addToScore(-1);
            //Alternativ för när ship crascher med de olika Spaceobjekten.
        }
    }

    public void findAndHandleCrash(Screen screen, Score score) throws InterruptedException {
        for (Iterator<SpaceObject> iterator = this.objectsInWorld.iterator(); iterator.hasNext(); ) {
            SpaceObject spaceobject = iterator.next();
            if (ShipSamePositionAsSpaceObject(this.ship, spaceobject)) {
                craschAlternatives(spaceobject, screen, score);
                iterator.remove();
                break;
            }
        }
        // Om ship är på samma plats som Spaceobject --> aktivera craschAlternatives.
    }

    private void moveShip(Screen screen) {
        Key key;
        Key tempkey = null;
        do {
            key = tempkey;
            tempkey = screen.readInput();
        } while (tempkey != null);
        if (key != null)
            ship.move(key.getCharacter());
    }

    private boolean ShipSamePositionAsSpaceObject(Ship ship, SpaceObject spaceObject) {
        for (Coordinates coordinates : ship.generateListOfCoordinates()) {
            if (spaceObject.getxCoordinate() == coordinates.getxCoordinate() && spaceObject.getyCoordinate() == coordinates.getyCoordinate()) {
                return true;
            }
        }
        return false;

    }
}
