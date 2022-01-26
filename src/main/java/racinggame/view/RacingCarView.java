package racinggame.view;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

public class RacingCarView {

    private RacingCar racingCar;

    private RacingCarView(RacingCar racingCar) {
        this.racingCar = racingCar;
    }

    public static List<RacingCarView> racingCarOf(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(RacingCarView::new)
                .collect(Collectors.toList());
    }

    public String drawCurrPosition() {
        String trace = Utils.repeat("-", this.racingCar.getPosition());
        return String.format("%-5s: %s\n", this.racingCar.getCarName(), trace);
    }
}
