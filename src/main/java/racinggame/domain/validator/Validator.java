package racinggame.domain.validator;

import static racinggame.exception.ExceptionBaseMessage.INPUT_BLANK_MESSAGE;
import static racinggame.exception.ExceptionBaseMessage.LACK_OF_PLAYER_MESSAGE;
import static racinggame.exception.ExceptionBaseMessage.NAME_LENGTH_OVER_MESSAGE;
import static racinggame.exception.ExceptionBaseMessage.NOT_A_NUMBER_EXCEPTION_MESSAGE;

import java.util.List;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;

public class Validator {

    public static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String NUMERIC_REGEX = "[0-9]+";

    private Validator() {}

    public static void validatePossibleToStart(final RacingCars racingCars) {
        if (isPossibleToStart(racingCars.get())) {
            throw new LackOfPlayerException(
                    String.format("%s (현재 참여인원 %d)", LACK_OF_PLAYER_MESSAGE, racingCars.get().size()));
        }
    }

    private static boolean isPossibleToStart(final List<RacingCar> racingCars) {
        return racingCars.size() < MINIMUM_PLAYER;
    }

    public static void validateNameLength(final String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new NameLengthOverException(
                    String.format("%s (Input: %s)", NAME_LENGTH_OVER_MESSAGE, carName));
        }
    }

    public static void validateIsNumber(final String trial) {
        if(isNotNumber(trial)){
            throw new NumberFormatException(NOT_A_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNotNumber(String trial) {
        return !trial.matches(NUMERIC_REGEX);
    }

    public static void checkNameIsBlank(final String[] splitName) {
        for (int i = 0; i < splitName.length; i++) {
            if (splitName[i].isEmpty()) {
                throw new InputBlankException(
                        String.format("%s (%d번째 자동차 이름이 공백입니다.", INPUT_BLANK_MESSAGE, i));
            }
        }
    }
}