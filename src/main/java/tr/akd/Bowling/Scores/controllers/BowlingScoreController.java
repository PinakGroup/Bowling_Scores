package tr.akd.Bowling.Scores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.akd.Bowling.Scores.models.BowlingScore;
import tr.akd.Bowling.Scores.models.Frame;
import tr.akd.Bowling.Scores.models.RestResponse;
import tr.akd.Bowling.Scores.services.BowlingScoreControllerService;


@RestController()
public class BowlingScoreController {

    private BowlingScoreControllerService bowlingScoreControllerService;

    public BowlingScoreController(
            BowlingScoreControllerService customerService) {
        this.bowlingScoreControllerService = customerService;
    }

    @RequestMapping(value = "/bowling", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<RestResponse> startNewGame() {

        String gameId = bowlingScoreControllerService.startNewGame();

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(gameId));
    }

    @RequestMapping(value = "/bowling/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<RestResponse> deleteGame(@PathVariable(value = "id") String id) {
        if (bowlingScoreControllerService.deleteGame(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new RestResponse("The game with given id is deleted successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestResponse("There is no game with given id."));
    }

    @RequestMapping(value = "/bowling/{id}/score", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<RestResponse> submitScore(@RequestBody Frame frame, @PathVariable(value = "id") String id) {

        if (bowlingScoreControllerService.submitScore(frame, id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestResponse("There is no game with given id."));
    }

    @RequestMapping(value = "/bowling/{id}/score", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<RestResponse> getScore(@PathVariable(value = "id") String id) {

        BowlingScore bowlingScore = bowlingScoreControllerService.getScore(id);
        if (bowlingScore == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestResponse("There is no game with given id."));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(bowlingScore));

    }
}
