package se.academy;

/**
 * Created by Emil Båth on 2016-08-31.
 */
public class Score {
    private int score;
    private String name;
    public static Score[] highScores = new Score[10];


    public Score() {
        this.score = 0;
        this.name = "unnamed";
    }

    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void addToScore(int points) {
        this.score += points;
    }

    public void addToHighScore() {
        for (int i = 0; i < 10; i++) {
            if (highScores[i] != null && this.score > highScores[i].getScore() && i < 9) {
                Score highScore = highScores[i];
                highScores[i] = this;
                highScore.addToHighScore();
                break;
            }
            else if (highScores[i] == null) {
                highScores[i] = this;
                break;
            }
        }
    }
}

