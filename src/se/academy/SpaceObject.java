package se.academy;

import java.util.Random;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
/**
 * Created by Emil Båth on 2016-08-30.
 */
abstract class SpaceObject {
    char c; // tecken för specifikt SpaceObjekt.
    int x;
    int y; // X och Y kordinat för SpaceObjekt.

    boolean willKillShip;
    boolean willMakeShipBigger;
    boolean willMakeShipSmaller;
// Egenskaper för vad som händer vid kollision.

    void fall() {
        y += 1;
    }
    // SpaceObjekt faller.

    Random xValue = new Random();

    public SpaceObject(Terminal terminal) {
        this.x = xValue.nextInt(terminal.getTerminalSize().getColumns() - 1);
        this.y = 0;

        // konstruktorn till SpaceObjekt. Tar ett random X värde innanför teminalen och Y är = 0.
    }
}
