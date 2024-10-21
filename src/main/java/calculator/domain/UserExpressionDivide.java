package calculator.domain;

import calculator.domain.constant.Unit;

public class UserExpressionDivide {

    private static UserExpression userExpression;
    private static String raw;
    private static int minCustomDelimLength;

    private UserExpressionDivide(UserExpression inputExpression) {
        userExpression = inputExpression;
        raw = userExpression.getRawExpression();
        minCustomDelimLength = Unit.MIN_CUSTOM_DELIM_LENGTH.getValue();
    }

    public static UserExpression complete(UserExpression expression) {
        new UserExpressionDivide(expression);
        divideExpression();
        return expression;
    }

    private static Boolean enoughLength() {
        return raw.length() >= minCustomDelimLength;
    }

    private static void divideExpression() {
        setEssential();
        if(enoughLength()){
            setDivide();
        }
    }

    private static void setDivide() {
        userExpression.setDivideValues(raw.substring(Unit.START.getValue(), minCustomDelimLength)
                , raw.substring(minCustomDelimLength, raw.length()));
    }

    private static void setEssential () {
        userExpression.setEssentialExpression(raw);
    }
}
