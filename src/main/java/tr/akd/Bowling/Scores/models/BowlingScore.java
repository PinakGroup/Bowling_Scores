package tr.akd.Bowling.Scores.models;

public class BowlingScore {
    private int totalScore;
    private int frameScores[];

    public BowlingScore(int totalScore, int[] frameScores) {
        this.totalScore = totalScore;
        this.frameScores = frameScores;
    }

    public BowlingScore() {

    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int[] getFrameScores() {
        return frameScores;
    }

    public void setFrameScores(int[] frameScores) {
        this.frameScores = frameScores;
    }
}
