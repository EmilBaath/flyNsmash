package se.academy;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Stone extends SpaceObject {
    public Stone(Terminal terminal) {
        super(terminal);
        super.c = '§';
        super.willKillShip = true;
        super.willMakeShipBigger = false;
        super.willMakeShipSmaller = false;

        // Konstruktorn till SpaceObjektet "s".

    }
}
