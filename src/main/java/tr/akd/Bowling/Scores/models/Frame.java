package tr.akd.Bowling.Scores.models;

public class Frame {

    public Frame() {
        firstRoll = 0;
        secondRoll = 0;
        thirdRoll = 0;
        isScored = false;
    }

    private int firstRoll;
    private int secondRoll;
    private int thirdRoll; // For last frame

    private Boolean isScored;

    public Boolean isStrike() {
        return firstRoll == 10;
    }

    public Boolean isSpare() {
        return (firstRoll + secondRoll) == 10;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(int thirdRoll) {
        this.thirdRoll = thirdRoll;
    }

    public Boolean isScored() {
        return isScored;
    }

    public void setScored(Boolean scored) {
        isScored = scored;
    }
}
