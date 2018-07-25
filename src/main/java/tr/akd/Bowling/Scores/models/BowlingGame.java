package tr.akd.Bowling.Scores.models;

public class BowlingGame {
    public BowlingGame() {
        currentFrame = 1;
        frames = new Frame[11]; // First one is left blank intentionally for matching array index and frame number.
    }

    private int currentFrame;


    private Frame[] frames;

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public Frame[] getFrames() {
        return frames;
    }

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }

    public Frame getFrame(int i){
        return frames[i];
    }

    public int getFrameScore(int frameNo) {
        Frame frame = frames[frameNo];
        if(frame == null){
            return 0;
        }
        if (frame.isStrike()) {
            if(strikeBonus(frameNo) == 0){
                frame.setScored(false);
                return 0;
            }
            frame.setScored(true);
            return 10 + strikeBonus(frameNo);
        }
        if (frame.isSpare()) {
            if(spareBonus(frameNo) == 0){
                frame.setScored(false);
                return 0;
            }
            frame.setScored(true);
            return 10 + spareBonus(frameNo);
        }
        frame.setScored(true);
        return frame.getFirstRoll() + frame.getSecondRoll();
    }

    private int spareBonus(int frameNo) {
        if (frameNo == 10) {
            Frame lastFrame = frames[frameNo];
            return lastFrame.getThirdRoll();
        }
        Frame nextFrame = frames[frameNo + 1];
        return nextFrame == null ? 0 : nextFrame.getFirstRoll();
    }

    private int strikeBonus(int frameNo) {
        if (frameNo == 10) {
            Frame lastFrame = frames[frameNo];
            return lastFrame.getSecondRoll() + lastFrame.getThirdRoll();
        }
        Frame nextFrame = frames[frameNo + 1];
        if(nextFrame == null){
            return 0;
        }
        if (nextFrame.isStrike()) {
            if (frameNo == 9) {
                return 10 + nextFrame.getSecondRoll(); // next frame is the last frame which is special
            }
            Frame nextNextFrame = frames[frameNo + 2];
            return nextNextFrame==null ? 0 : 10 + nextNextFrame.getFirstRoll();
        }
        return nextFrame.getFirstRoll() + nextFrame.getSecondRoll();
    }
}
