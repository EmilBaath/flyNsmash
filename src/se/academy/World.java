package se.academy;

import com.googlecode.lanterna.terminal.Terminal;

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



    public void updateWorld(Terminal terminal) {
        movingItemsInWorld(terminal);
        addSpaceObject(terminal );
        //Ger ett nytt fall och flyttar neråt.
    }

    private void movingItemsInWorld(Terminal terminal) {
        for (Iterator<SpaceObject> iterator = itemsInWorld.iterator(); iterator.hasNext(); ) {
            SpaceObject spaceObject = iterator.next();
            // Iterator behövs för att kunna ta bort element i listan.

            if (spaceObject.y >= terminal.getTerminalSize().getRows() - 1) {
                iterator.remove();
                // Tar bort object när de har kommit till botten.
            } else {
                spaceObject.fall();
                //Flyttar alla SpaceObjects neråt.

            }

        }
    }

    private void addSpaceObject(Terminal terminal) {
        int randomNumber = generator.nextInt(3);
        switch (randomNumber) {
            case 0:
                itemsInWorld.add(new Stone(terminal));
                break;
            case 1:
                itemsInWorld.add(new Plus(terminal));
                break;
            case 2:
                itemsInWorld.add(new Minus(terminal));
                break;
            // genererar alla stenar, + och - slumpmässigt.
        }
    }
}
