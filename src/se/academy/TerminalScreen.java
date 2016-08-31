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
        this.terminal.enterPrivateMode();
        this.terminal.setCursorVisible(false);
    }

    @Override
    public void printScreen(World world, Score score) throws InterruptedException {

        printText("Dina poäng: " + score.getScore(), 0);
        for (int i = 0; i < numberOfColumns(); i++) {
            terminal.moveCursor(i, 1);
            terminal.putCharacter('-');
        }

        for (int i = 0; i < world.objectsInWorld.size(); i++) {
            terminal.moveCursor(world.objectsInWorld.get(i).getxCoordinate(), world.objectsInWorld.get(i).getyCoordinate());
            terminal.putCharacter(world.objectsInWorld.get(i).getCharOnScreen());
        }

        for (Coordinates coordinates : world.ship.generateListOfCoordinates()) {
            terminal.moveCursor(coordinates.getxCoordinate(), coordinates.getyCoordinate());
            terminal.putCharacter('O');
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
    public void printText(String text, int row) {
        for (int i = 0; i < text.length(); i++) {
            this.terminal.moveCursor(this.numberOfColumns() / 2 + i, row);
            this.terminal.putCharacter(text.charAt(i));
        }
    }

    @Override
    public void clearScreen() {
        terminal.clearScreen();
    }

    @Override
    public void printStartMeny() throws InterruptedException {
        printText("1. Starta nytt spel", numberOfRows() / 2 - 1);
        printText("2. Se highscore", numberOfRows() / 2);
        printText("3. Avsluta", numberOfRows() / 2 + 1);
        Key key = readInput();
        while (key == null) {
            Thread.sleep(5);
            key = readInput();
        }
        String choice = ""  + key.getCharacter();
        printText(choice, numberOfRows() / 2 + 3);
        switch (choice) {
            case "1":
                break;
            case "2":
                clearScreen();
                printHighScore();
                Thread.sleep(2000);
                clearScreen();
                printStartMeny();
                break;
            case "3":
                clearScreen();
                printText("Ha det gött, haj!", numberOfRows() / 2);
                Thread.sleep(500);
                System.exit(0);
                break;
        }
    }

    @Override
    public void printHighScore() {
        Score[] highScores = Score.highScores;
        for (int i = 0; i < highScores.length; i++) {
            if (highScores[i] != null) {
                String scoreString = highScores[i].getName() + " : " + highScores[i].getScore();
                printText(scoreString, numberOfRows() / 2 - 5 + i);
            }
        }
    }

    @Override
    public Key readInput() {
        return terminal.readInput();
    }


    @Override
    public String readText() throws InterruptedException {
        terminal.setCursorVisible(true);
        String text = "";
        while (true) {
            Key key = null;
            while (key == null) {
                Thread.sleep(5);
                key = readInput();
            }
            if (key.getCharacter() == '\n') {
                break;
            }
            if (key.getKind() == Key.Kind.Backspace) {
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                }
            } else {
                text += key.getCharacter();
            }
            printText(text, numberOfRows() / 2 + 1);
        }
        terminal.setCursorVisible(false);
        return text;
    }
}
