package se.academy;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Stone extends SpaceObject {
    public Stone(Screen screen) {
        super(screen);
        super.setCharOnScreen('§');
        super.willKillShip = true;
        super.willMakeShipBigger = false;
        super.willMakeShipSmaller = false;

        // Konstruktorn till SpaceObjektet "s".

    }
}
