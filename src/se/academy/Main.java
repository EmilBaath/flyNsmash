package se.academy;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class Main  {

    public static void main(String[] args) throws InterruptedException {
        Screen.printScreen(new World());
    }
}
