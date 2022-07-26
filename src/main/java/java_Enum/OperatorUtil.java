package java_Enum;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperatorUtil {

    PLUS("+", OperatorUtil::plus),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operator;
    private BinaryOperator<String> binaryOperator;

    OperatorUtil(String operator, BinaryOperator binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static String operate(String operator, String num1, String num2) {
        return getOperator(operator).binaryOperator.apply(num1, num2);
    }

    private static OperatorUtil getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("연산자가 올바르지 않습니다."));
    }

    private static String plus(Object num1, Object num2) {
        return new BigDecimal((String) num1).add(new BigDecimal((String) num2)).toString();
    }

    private static String minus(Object num1, Object num2) {
        return new BigDecimal((String) num1).subtract(new BigDecimal((String) num2)).toString();
    }

    private static String multiply(Object num1, Object num2) {
        return new BigDecimal((String) num1).multiply(new BigDecimal((String) num2)).toString();
    }

    private static String divide(Object num1, Object num2) {
        return new BigDecimal((String) num1).divide(new BigDecimal((String) num2)).toString();
    }

}
