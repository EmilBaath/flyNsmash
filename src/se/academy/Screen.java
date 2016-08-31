package se.academy;

import com.googlecode.lanterna.input.Key;

/**
 * Created by Emil Båth on 2016-08-31.
 */
interface Screen {
    void printScreen(World world, Score score) throws InterruptedException;
    int numberOfRows();
    int numberOfColumns();
    void printText(String text, int row);
    void clearScreen();
    void printStartMeny() throws InterruptedException;
    void printHighScore();
    Key readInput();
    String readText() throws InterruptedException;
}
