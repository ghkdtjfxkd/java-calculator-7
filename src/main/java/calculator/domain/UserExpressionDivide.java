package calculator.domain;

import calculator.domain.constant.Unit;

public class UserExpressionDivide {

    private static UserExpression userExpression;
    private static String rawExpression;
    private static final int minCustomDelimLength = Unit.MIN_CUSTOM_DELIM_LENGTH.getValue();

    private static void setting(UserExpression expression) {
        userExpression = expression;
        rawExpression = userExpression.getRawExpression();
        userExpression.setCustomDelimExpressionCandidate(rawExpression);
        userExpression.setEssentialExpression(rawExpression);
    }

    public static void dividePart(UserExpression expression) {
        setting(expression);
        if(enoughLengthToDivide(rawExpression)) {
            assignCandidate(rawExpression);
            assignRemainingPart(rawExpression);
        }
    }

    private static Boolean enoughLengthToDivide(String rawExpression) {
        return rawExpression.length() >= minCustomDelimLength;
    }

    private static void assignCandidate(String rawExpression) {
        userExpression.setCustomDelimExpressionCandidate(rawExpression.substring(0,minCustomDelimLength));
    }

    private static void assignRemainingPart(String rawExpression) {
        userExpression.setEssentialExpression(rawExpression
                        .replace(userExpression.getCustomDelimExpressionCandidate(),""));
        onlyCustomDelimExistInRawExpression();
    }

    private static void onlyCustomDelimExistInRawExpression() {
        if(userExpression.getEssentialExpression().isEmpty()) {
            userExpression.setEssentialExpression("0");
        }
    }

    public static UserExpression setDivideCustomDelimDisappear() {
        userExpression.setEssentialExpression(userExpression.getRawExpression());
        return userExpression;
    }
}
