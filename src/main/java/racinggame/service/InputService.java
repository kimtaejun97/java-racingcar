package racinggame.service;

import racinggame.domain.Validator;

public class InputService {

    private static final String SEPARATOR = ",";
    private static final String BLANK = "\\s+";
    private static final String EMPTY_STRING = "";


    public String[] getCarNames(String inputCarNames) {
        String removedBlankInput = removeBlank(inputCarNames);
        Validator.checkIsBlank(removedBlankInput);

        return splitNameByComma(removedBlankInput);
    }

    public int getTrial(String inputTrial) {
        String removedBlankInput = removeBlank(inputTrial);
        Validator.checkIsBlank(removedBlankInput);

        return Integer.parseInt(removedBlankInput);
    }

    private String removeBlank(String trial) {
        return trial.replaceAll(BLANK, EMPTY_STRING);
    }

    private String[] splitNameByComma(String inputCarNames) {
        return inputCarNames.split(SEPARATOR);
    }
}
