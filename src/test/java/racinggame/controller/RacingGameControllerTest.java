package racinggame.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCar;
import racinggame.service.InputService;
import racinggame.view.InputView;

class RacingGameControllerTest {

    RacingGameController controller = new RacingGameController(new InputView(), new InputService());

    @Test
    void getRacingCars() {
        String userInput = "car1, car2";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        List<RacingCar> racingCars = controller.getRacingCars();

        assertThat(racingCars.size()).isEqualTo(2);
        assertThat(racingCars.get(0).getCarName()).isEqualTo("car1");
        assertThat(racingCars.get(1).getCarName()).isEqualTo("car2");
    }

    @Test
    void getTrial() {
        String userInput = "5";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        int trial = controller.getTrial();
        assertThat(trial).isEqualTo(5);
    }
}