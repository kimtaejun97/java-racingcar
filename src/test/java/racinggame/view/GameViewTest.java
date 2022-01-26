package racinggame.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCar;

class GameViewTest {

    @Test
    void 상태를_출력할_자동차_리스트를_받아_생성한다() throws NoSuchFieldException, IllegalAccessException {

        // given
        String[] cars = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.racingCarOf(cars);

        // when
        GameView gameView = new GameView(racingCars);
        Field racingCarViewsField = GameView.class.getDeclaredField("racingCarViews");
        racingCarViewsField.setAccessible(true);

        List<RacingCarView> racingCarViews = (List<RacingCarView>) racingCarViewsField.get(gameView);
        // then
        System.out.println(racingCarViews);
    }

    @Test
    void 현재_자동차들의_상태를_출력한다() {

        // given
        String[] cars = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.racingCarOf(cars);
        GameView gameView = new GameView(racingCars);

        // when
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        gameView.printProgress();

        // then
        assertTrue(out.toString().contains("car1"));
        assertTrue(out.toString().contains("car2"));
    }
}
