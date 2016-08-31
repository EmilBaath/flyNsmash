package se.academy;

import javax.swing.*;

public class Main  {

    public static void main(String[] args) throws InterruptedException {
        World world = new World();
        Screen screen = new TerminalScreen();
        StartMeny.createStartMeny(screen,world);
// Startar spelet.

    }
}
