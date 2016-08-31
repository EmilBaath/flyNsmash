package se.academy;

import java.util.Random;

/**
 * Created by Emil Båth on 2016-08-30.
 */
abstract class SpaceObject {
    private char charOnScreen; // tecken för specifikt SpaceObjekt.
    private int xCoordinate;
    private int yCoordinate; // X och Y kordinat för SpaceObjekt.

    boolean willKillShip;
    boolean willMakeShipBigger;
    boolean willMakeShipSmaller;
// Egenskaper för vad som händer vid kollision.


    public void setCharOnScreen(char charOnScreen) {
        this.charOnScreen = charOnScreen;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public char getCharOnScreen() {
        return charOnScreen;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    void fall() {
        yCoordinate += 1;
    }
    // SpaceObjekt faller.

    Random xValue = new Random();

    public SpaceObject(Screen screen) {
        this.xCoordinate = xValue.nextInt(screen.numberOfColumns() - 1);
        this.yCoordinate = 0;

        // konstruktorn till SpaceObjekt. Tar ett random X värde innanför teminalen och Y är = 0.
    }
}
