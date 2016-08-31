package se.academy;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Minus extends SpaceObject {
    public Minus(Screen screen) {
        super(screen);
        super.setCharOnScreen('-');
        super.willKillShip = false;
        super.willMakeShipBigger = false;
        super.willMakeShipSmaller = true;

        // Konstruktorn till SpaceObjektet "-".

    }
}
