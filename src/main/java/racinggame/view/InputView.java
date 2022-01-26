package racinggame.view;

import java.util.Scanner;

public class InputView {

    public InputView() {
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 ','로 구분해서 입력하세요.(2대 이상)");
        return getInput();
    }

    public String inputTrial() {
        System.out.print("시도 횟수를 입력해 주세요: ");
        return getInput();
    }

    public String inputIsRestart() {
        System.out.println("게임이 종료되었습니다. (종료 = q, 다시 시작 = 아무 키 입력)");
        return getInput();
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
