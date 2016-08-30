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
                center.y -= 1;
                break;
            case ArrowDown:
                center.y += 1;
                break;
            case ArrowLeft:
                center.x -= 1;
                break;
            case ArrowRight:
                center.x += 1;
                break;
            // Rör ditt skepp.
        }
    }

    public List<Point> generateListOfPointInShip() {
        List<Point> points = new ArrayList<Point>();
        for (int i = center.x - radius; i <= center.x + radius; i++) {
            for (int j = center.y - radius; j <= center.y + radius; j++) {
                if (Math.sqrt(Math.pow(center.x - i, 2) + Math.pow(center.y - j, 2)) < radius) {
                    points.add(new Point(i, j));
                    //Lägger till punkter som ska ritas ut i skeppet.
                }
            }
        }
        return points;
    }
}
