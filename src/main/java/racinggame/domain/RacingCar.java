package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.view.RacingCarView;

public class RacingCar {

    private static final int MINIMUM_FORWARD_VALUE = 4;
    private static final int INIT_POSITION = 0;

    private final RacingCarView racingCarView;
    private String carName;
    private int carPosition;

    private RacingCar(String carName) {
        this(carName, INIT_POSITION);
    }

    public RacingCar(String carName, int position) {
        racingCarView = new RacingCarView(this);
        this.carName = carName;
        this.carPosition = position;
    }

    public static List<RacingCar> racingCarOf(String[] carNames) {
        return Arrays.stream(carNames).map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public boolean canForward(int randomValue) {
        return randomValue >= MINIMUM_FORWARD_VALUE;
    }

    public void forward() {
        this.carPosition += 1;
    }

    public String drawCurrPosition() {
        return this.racingCarView.drawCurrPosition();
    }

    public int getPosition() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }
}
