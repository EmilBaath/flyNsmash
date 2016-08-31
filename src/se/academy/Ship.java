package se.academy;

import com.googlecode.lanterna.input.Key;
import com.sun.glass.events.KeyEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Ship {
    Point center = new Point(49, 28);
    int radius = 1;

    public void makeShipBigger() {
        radius += 1;
    }
    // Gör radius på skeppet lite större.
    public void makeShipSmaller() {
        if (radius > 1)
            radius -= 1;
    }
    // gör radius på skeppet lite mindre.

    public void moveShip(Key key) {
        Key.Kind k = key.getKind();
        switch (k) {
            case ArrowUp:
                center.setyCoordinate(center.getyCoordinate() - 1);
                break;
            case ArrowDown:
                center.setyCoordinate(center.getyCoordinate() +1);
                break;
            case ArrowLeft:
                center.setxCoordinate(center.getxCoordinate() -1);
                break;
            case ArrowRight:
                center.setxCoordinate(center.getxCoordinate() +1);
                break;
            // Rör ditt skepp.
        }
    }

    public List<Point> generateListOfPointInShip() {
        List<Point> points = new ArrayList<Point>();
        for (int i = center.getxCoordinate() - radius; i <= center.getxCoordinate() + radius; i++) {
            for (int j = center.getyCoordinate() - radius; j <= center.getyCoordinate() + radius; j++) {
                if (Math.sqrt(Math.pow(center.getxCoordinate() - i, 2) + Math.pow(center.getyCoordinate() - j, 2)) < radius) {
                    points.add(new Point(i, j));
                    //Lägger till punkter som ska ritas ut i skeppet.
                }
            }
        }
        return points;
    }
}
