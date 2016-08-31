package se.academy;

import com.googlecode.lanterna.input.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Ship {
    Coordinates center = new Coordinates(49, 28);
    int radius = 2;

    public void makeShipBigger() {
        radius += 1;
    }

    public void makeShipSmaller() {
        if (radius > 1)
            radius -= 1;
    }

    public void move(char direction) {
        switch (direction) {
            case 'U':
                center.setyCoordinate(center.getyCoordinate() - 1);
                break;
            case 'D':
                center.setyCoordinate(center.getyCoordinate() +1);
                break;
            case 'L':
                center.setxCoordinate(center.getxCoordinate() -1);
                break;
            case 'R':
                center.setxCoordinate(center.getxCoordinate() +1);
                break;
        }
    }

    public List<Coordinates> generateListOfCoordinates() {
        List<Coordinates> coordinates = new ArrayList<>();
        for (int i = center.getxCoordinate() - radius; i <= center.getxCoordinate() + radius; i++) {
            for (int j = center.getyCoordinate() - radius; j <= center.getyCoordinate() + radius; j++) {
                if (Math.sqrt(Math.pow(center.getxCoordinate() - i, 2) + Math.pow(center.getyCoordinate() - j, 2)) < radius) {
                    coordinates.add(new Coordinates(i, j));
                }
            }
        }
        return coordinates;
    }
}
