package study.step2_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void calculatorSetup(){
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("덧셈 테스트")
    @CsvSource(value ={"1 + 2 = 3", "2 + 2 = 4", "3 + 5 = 8"}, delimiter = '=')
    void addTest(String input, double result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트")
    @CsvSource(value ={"3 - 2 = 1", "4 - 2 = 2", "5 - 5 = 0"}, delimiter = '=')
    void subtractTest(String input, double result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 테스트")
    @CsvSource(value ={"3 * 2 = 6", "4 * 2 = 8", "5 * 5 = 25"}, delimiter = '=')
    void multiplyTest(String input, double result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 테스트")
    @CsvSource(value ={"6 / 2 = 3", "4 / 2 = 2", "5 / 5 = 1"}, delimiter = '=')
    void divisionTest(String input, double result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 전체 혼합 테스트")
    @CsvSource(value ={"2 + 3 * 4 / 2 = 10", "5 - 2 * 4 / 2 + 6 = 12", "3 + 3 / 2 * 5 - 1 = 14"}, delimiter = '=')
    void operationsTest(String input, double result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw 하는 것 테스트")
    @ValueSource(strings = {"", " "})
    void returnExceptionCheckByBlankCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호 체크하는 메소드 테스트")
    @ValueSource(strings = {"3 + 5 & 4", "=","% 4 $ 2","3 * d"})
    void operationsSymbolCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("0으로 나눌 경우 IllegalArgumentException throw 하는 것 테스트")
    @ValueSource(strings = {"3 + 5 / 0"})
    void zeroMakeExceptionCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            calculator.calculate(input);
        });
    }

}