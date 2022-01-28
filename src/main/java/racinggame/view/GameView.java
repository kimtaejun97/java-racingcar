package racinggame.view;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.RacingCar;

public class GameView {

    private static final String DELIMITER = ", ";
    public static final String QUIT = "q";

    private List<CarResultView> carResultViews;

    public GameView(List<RacingCar> racingCars) {
        carResultViews = CarResultView.racingCarOf(racingCars);
    }

    public void printProgress() {
        StringBuilder sb = new StringBuilder();
        carResultViews.forEach(carView -> sb.append(carView.drawCurrResult()).append("\n"));

        System.out.println(sb);
    }

    public void printWinners(List<String> winners) {
        String result = winners.stream().collect(Collectors.joining(DELIMITER));
        System.out.println("최종 우승자: " + result);
    }

    public static boolean isQuit(String command) {
        return command.equals(QUIT);
    }
}
