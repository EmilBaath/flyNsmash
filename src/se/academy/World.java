package se.academy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class World {

    List<SpaceObject> itemsInWorld = new ArrayList<>(); // Lista med SpaceObjekt i world.
    private Random generator = new Random();
    Ship ship = new Ship();


    public void updateWorld(Screen screen) {
        movingItemsInWorld(screen);
        addSpaceObject(screen);
        //Ger ett nytt fall och flyttar neråt.
    }

    private void movingItemsInWorld(Screen screen) {
        for (Iterator<SpaceObject> iterator = itemsInWorld.iterator(); iterator.hasNext(); ) {
            SpaceObject spaceObject = iterator.next();
            // Iterator behövs för att kunna ta bort element i listan.

            if (spaceObject.getyCoordinate() >= screen.numberOfRows() - 1) {
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
                itemsInWorld.add(new Stone(screen));
                break;
            case 1:
                itemsInWorld.add(new Plus(screen));
                break;
            case 2:
                itemsInWorld.add(new Minus(screen));
                break;
            // genererar alla stenar, + och - slumpmässigt.
        }
    }
}
