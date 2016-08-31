package se.academy;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

/**
 * Created by Emil Båth on 2016-08-31.
 */
interface Screen {
    void printScreen(World world, Screen screen) throws InterruptedException;
    int numberOfRows();
    int numberOfColumns();
    void closeScreen();
    void printText(String text);
}
