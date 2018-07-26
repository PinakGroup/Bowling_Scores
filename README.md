A sample Spring Boot Api which provides a score calculation for bowling game.

# BUILD & RUN

To build clone this repository and run ‘mvn clean package’ command under the root directory.

After build is completed to run simply run ‘java -jar target\Bowling_Scores-0.0.1-SNAPSHOT.jar’ command.

# USAGE OF THE API

## Start New Game

> curl -H "Accept:application/json" http://localhost:8080/bowling

It will return a json object which stores the Id of the game. Example response:

> {"data":"1ad286a4-b44b-4325-aa8c-24fbdb53643c"}

## Delete a Game

> curl -X DELETE http://localhost:8080/bowling/cb269226-0a95-4f85-ac6d-0088d5fef49b

It will return a json object which stores a response message. Example response:

> {"data":"The game with given id is deleted successfully"} // If there is a game with given Id

> {"data":"There is no game with given id."} // If there is no game with given Id

## Submit Score

> curl -X POST -H "Content-Type:application/json" http://localhost:8080/bowling/5c35ea4f-531f-4fdf-8d0a-02981747ba84/score -d '{ "firstRoll": 5, "secondRoll": 2, "thirdRoll": 0 }'

It responses with status 204 no content if succeeds. If there is no game with given Id it returns and error like:
> {"data":"There is no game with given id."}

## Get Current Game Score

> curl -H "Accept:application/json" http://localhost:8080/bowling/5c35ea4f-531f-4fdf-8d0a-02981747ba84/score

It returns a json object which stores the total score and frameScores array. Example response:

> {"data":{"totalScore":7,"frameScores":[7,0,0,0,0,0,0,0,0,0]}}

> {"data":"There is no game with given id."} // If there is no game with given Id
