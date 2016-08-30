package se.academy;

import java.nio.charset.Charset;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class Screen {

    public static void printScreen(World world) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        //Skriv ut terminalen.

        boolean update = true;
        while (true) {
            GameLogic.findAndHandleCrasch(world);

            for (int i = 0; i < world.itemsInWorld.size(); i++) {
                terminal.moveCursor(world.itemsInWorld.get(i).x, world.itemsInWorld.get(i).y);
                terminal.putCharacter(world.itemsInWorld.get(i).c);
                // för varje spaceObject in world skriv ut i terminal
            }
            for (Point point : world.ship.generateListOfPointInShip()) {
                terminal.moveCursor(point.x, point.y);
                terminal.putCharacter('O');
                // skriv ut ship
            }
            if (update) {
                world.updateWorld(terminal);
                // flytta alla spaceObjects neråt och ta bort om i botten och skapa nya i toppen
            }
            update = !update; // för att bara köra update varannan loop
            Key key = null;
            Key tempkey = null;

            do {
                key = tempkey;
                tempkey = terminal.readInput();
            } while (tempkey != null);
            if (key != null)
                world.ship.moveShip(key);
            if (key != null)
                System.out.println(key.getCharacter() + key.getKind().toString());
            Thread.sleep(70);
            terminal.clearScreen();

            // För att vårt skeppet ska sluta flyttas när man ej trycker ned tangetnetne..


        }
    }
}
