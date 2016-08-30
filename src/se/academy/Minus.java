package se.academy;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Minus extends SpaceObject {
    public Minus(Terminal terminal) {
        super(terminal);
        super.c = '-';
        super.willKillShip = false;
        super.willMakeShipBigger = false;
        super.willMakeShipSmaller = true;

        // Konstruktorn till SpaceObjektet "-".

    }
}
