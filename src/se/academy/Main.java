package se.academy;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Screen screen = new TerminalScreen();
        while (true) {
            World world = new World();
            screen.printStartMeny();
            Score score = new Score();
            boolean updateObjects = true;
            while (true) {
                world.updateWorld(screen, updateObjects);
                updateObjects = !updateObjects;
                screen.printScreen(world, score);
                world.findAndHandleCrash(screen, score);
                Thread.sleep(50);
                screen.clearScreen();
                if (world.gameOver) {
                    break;
                }
            }
            screen.clearScreen();
            screen.printText("Game over noob!", screen.numberOfRows() / 2);
            screen.printText("Your score: " + score.getScore(), screen.numberOfRows() / 2 + 2);
            Thread.sleep(2000);
            screen.clearScreen();
            screen.printText("Enter name :", screen.numberOfRows() / 2);
            score.setName(screen.readText());
            score.addToHighScore();
            screen.clearScreen();
        }
    }
}
