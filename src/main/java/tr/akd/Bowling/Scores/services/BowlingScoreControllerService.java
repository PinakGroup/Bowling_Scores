package tr.akd.Bowling.Scores.services;

import org.springframework.stereotype.Component;
import tr.akd.Bowling.Scores.models.BowlingScore;
import tr.akd.Bowling.Scores.models.Frame;

public interface BowlingScoreControllerService {

    public String startNewGame();

    public Boolean deleteGame(String id);

    public Boolean submitScore(Frame frame, String id);

    public BowlingScore getScore(String id);
}
