package calculator.domain;

import java.util.List;

public class Calculator {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private Calculator() {}

    public static double evaluate(Expression expression) {
        List<Double> terms = expression.getTerms();
        List<String> operators = expression.getOperators();

        double acc = getFirstTerm(terms);
        for (int i = 0; i < operators.size(); i++) {
            acc = calculate(acc, terms.get(i + 1), operators.get(i));
        }

        return acc;
    }

    private static double getFirstTerm(List<Double> terms) {
        return terms.get(0);
    }

    private static double calculate(double acc, double term, String op) {
        switch (op) {
            case ADD:
                return add(acc, term);
            case SUBTRACT:
                return subtract(acc, term);
            case MULTIPLY:
                return multiply(acc, term);
            case DIVIDE:
                return divide(acc, term);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
        }
    }

    private static double add(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
