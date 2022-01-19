package racinggame.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private Input() {}

    public static String[] getCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 ','로 구분해서 입력하세요.(2대 이상)");

        String inputCarNames = br.readLine().trim();
        String[] carNames = splitNameByComma(inputCarNames);

        Validator.validatePossibleToStart(carNames);
        validateNameLengthFromCarNames(carNames);

        return carNames;
    }

    private static String[] splitNameByComma(String inputCarNames) {
        return inputCarNames.split(",");
    }

    private static void validateNameLengthFromCarNames(String[] carNames) {
        for (String carName : carNames) {
            Validator.validateNameLength(carName);
        }
    }

    public static int getTrial() throws IOException {
        String trial =  br.readLine();
        Validator.isNumber(trial);

        return Integer.parseInt(trial);
    }
}
