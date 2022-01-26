package racinggame.controller;

import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameController {

    private final InputView inputView;
    private final GameView gameView;

    public RacingGameController(InputView inputView, GameView gameView) {
        this.inputView = inputView;
        this.gameView = gameView;
    }

}
