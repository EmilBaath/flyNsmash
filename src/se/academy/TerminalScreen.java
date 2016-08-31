package se.academy;

import java.nio.charset.Charset;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Emil Båth on 2016-08-30.
 */
public class TerminalScreen implements Screen {
    private Terminal terminal;

    public TerminalScreen() {
        this.terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
    }

    public void printScreen(World world, Screen screen) throws InterruptedException {
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        //Skriv ut terminalen.

        Score score = new Score();
        boolean update = true;
        while (true) {
            GameLogic.findAndHandleCrasch(world, screen, score);

            for (int i = 0; i < world.itemsInWorld.size(); i++) {
                terminal.moveCursor(world.itemsInWorld.get(i).getxCoordinate(), world.itemsInWorld.get(i).getyCoordinate());
                terminal.putCharacter(world.itemsInWorld.get(i).getCharOnScreen());
                // för varje spaceObject in world skriv ut i terminal
            }
            for (Point point : world.ship.generateListOfPointInShip()) {
                terminal.moveCursor(point.getxCoordinate(), point.getyCoordinate());
                terminal.putCharacter('O');
                // skriv ut ship
            }
            if (update) {
                world.updateWorld(screen);
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
            Thread.sleep(70);
            terminal.clearScreen();

            // För att vårt skeppet ska sluta flyttas när man ej trycker ned tangetnetne..


        }
    }

    @Override
    public int numberOfRows() {
        return terminal.getTerminalSize().getRows();
    }

    @Override
    public int numberOfColumns() {
        return terminal.getTerminalSize().getColumns();
    }

    @Override
    public void closeScreen() {
        terminal.exitPrivateMode();
    }

    @Override
    public void printText(String text) {
        this.terminal.clearScreen();
        this.terminal.moveCursor(this.numberOfColumns() / 2,this.numberOfRows() / 2);
        for (int i = 0; i < text.length(); i++) {
            this.terminal.putCharacter(text.charAt(i));
            this.terminal.moveCursor(this.numberOfColumns() / 2 + 1 + i, this.numberOfRows() / 2);
        }
    }
}
