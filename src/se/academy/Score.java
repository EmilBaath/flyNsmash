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

    public void addToScore (int score) {
        this.score += score;
    }

    public void subtractFromScore(int score) {
        this.score -= score;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public int getScore() {
        return this.score;
    }

    public  String getName() {
        return this.name;
    }

    public void addToHighScore() {
        for (int i = 0; i < 10; i++) {
            if (highScores[i] == null || this.score >= highScores[i].getScore()) {
                if (highScores[i] != null && this.score >= highScores[i].getScore() && i < 9) {
                    highScores[i+1] = highScores[i];
                }
                highScores[i] = this;
                break;
            }
            // Kollar ifall dina points är högra än de 10 högsta poängen. Isf hamnar du på highscore listan.

        }

    }
}
