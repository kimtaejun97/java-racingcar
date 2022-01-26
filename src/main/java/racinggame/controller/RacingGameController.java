package racinggame.controller;

import java.util.List;
import racinggame.domain.Judge;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingGame;
import racinggame.service.InputService;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameController {

    private final InputView inputView;
    private final InputService inputService;
    private GameView gameView;

    public RacingGameController(InputView inputView, InputService inputService) {
        this.inputView = inputView;
        this.inputService = inputService;
    }

    public List<RacingCar> getRacingCars() {
        String[] carNames = inputService.parseCarNames(inputView.inputCarNames());
        return RacingCar.racingCarOf(carNames);
    }

    public int getTrial() {
        return inputService.parseTrial(inputView.inputTrial());
    }

    public void startGame(List<RacingCar> racingCars, int trial) {
        for (int i = 0; i < trial; i++) {
            gameView = new GameView(racingCars);
            RacingGame racingGame = new RacingGame(racingCars);

            racingGame.progress();
            gameView.printProgress();
        }
    }

    public void printWinners(List<RacingCar> racingCars) {
        gameView.printWinners(Judge.getWinners(racingCars));
    }

    public void checkIsRestart() {
        if (gameView.isQuit(inputView.inputIsRestart())) {
            System.exit(0);
        }
    }
}
