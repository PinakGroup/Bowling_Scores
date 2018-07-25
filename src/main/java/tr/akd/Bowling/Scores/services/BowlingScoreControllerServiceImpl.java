package tr.akd.Bowling.Scores.services;

import org.springframework.stereotype.Component;
import tr.akd.Bowling.Scores.models.BowlingGame;
import tr.akd.Bowling.Scores.models.BowlingScore;
import tr.akd.Bowling.Scores.models.Frame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

@Component
public class BowlingScoreControllerServiceImpl implements BowlingScoreControllerService {

    private HashMap<String, BowlingGame> bowlingGameHashMap = new HashMap<>();

    @Override
    public String startNewGame() {
        String gameId = UUID.randomUUID().toString();
        while (bowlingGameHashMap.containsKey(gameId)) { // To prevent assigning same id to different games
            gameId = UUID.randomUUID().toString();
        }
        bowlingGameHashMap.put(gameId, new BowlingGame());

        return gameId;
    }

    @Override
    public Boolean deleteGame(String id) {
        if (!bowlingGameHashMap.containsKey(id)) {
            bowlingGameHashMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean submitScore(Frame frame, String id) {
        if (!bowlingGameHashMap.containsKey(id)) {
            return false;
        }
        BowlingGame bowlingGame = bowlingGameHashMap.get(id);
        int currentFrame = bowlingGame.getCurrentFrame();
        bowlingGame.getFrames()[currentFrame] = frame;
        bowlingGame.setCurrentFrame(currentFrame + 1);
        return true;
    }

    @Override
    public BowlingScore getScore(String id) {
        if (!bowlingGameHashMap.containsKey(id)) {
            return null;
        }
        BowlingGame bowlingGame = bowlingGameHashMap.get(id);
        int currentFrame = bowlingGame.getCurrentFrame();
        int totalScore = 0;
        int frameScores[] = new int[10];
        Arrays.fill(frameScores, 0);
        for (int i = 1; i < currentFrame; i++) {
            Frame frame = bowlingGame.getFrame(i);
            int frameScore = bowlingGame.getFrameScore(i);
            if (frame.isScored()) {
                totalScore += frameScore;
                frameScores[i - 1] = totalScore;
            }
        }
        return new BowlingScore(totalScore, frameScores);
    }
}
