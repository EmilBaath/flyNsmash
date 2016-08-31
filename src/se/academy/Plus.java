package se.academy;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Plus extends SpaceObject {

    public Plus(Screen screen) {
        super(screen);
        super.setCharOnScreen('+');
        super.willKillShip = false;
        super.willMakeShipBigger = true;
        super.willMakeShipSmaller = false;

        // Konstruktorn till SpaceObjektet "+".
    }
}
