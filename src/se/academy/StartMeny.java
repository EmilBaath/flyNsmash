package se.academy;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Emil Båth on 2016-08-31.
 */
public class StartMeny {

    public static void createStartMeny(Screen screen, World world) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        System.out.println("1. Starta nytt spel");
        System.out.println("2. Se highscore");
        System.out.println("3. Avsluta");

        int nummer = in.nextInt();

        switch (nummer) {
            case 1:
                screen.printScreen(world, screen);
                // Starta nytt spel.
                break;
            case 2:
                printHigScore();
                Thread.sleep(2000);
                createStartMeny(screen, world);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Ha det gött, haj!");
                System.exit(0);
                break;
        }
    }

    public static void printHigScore() {
        Score[] highScores = Score.highScores;
        for (int i = 0; i < highScores.length; i++) {
            if (highScores[i] != null) {
                String scoreString = highScores[i].getName() + " : " + highScores[i].getScore();
                System.out.println(scoreString);
            }
        }
    }
}
