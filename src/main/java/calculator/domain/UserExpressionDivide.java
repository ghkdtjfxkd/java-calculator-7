package calculator.domain;

import calculator.domain.constant.Unit;

public class UserExpressionDivide {

    private static UserExpression userExpression;
    private static String rawExpression;
    private static String candidate;
    private static String remainingPart;
    private static final int minCustomDelimLength = Unit.MIN_CUSTOM_DELIM_LENGTH.getValue();


    public static void dividePart(UserExpression expression) {
        setting(expression);
        if(enoughLengthToDivide(rawExpression)) {
            assignCandidate(rawExpression);
            assignRemainingPart(rawExpression);
        }
    }

    private static void setting(UserExpression expression) {
        userExpression = expression;
        rawExpression = userExpression.getRawExpression();
        candidate = rawExpression;
        remainingPart = rawExpression;
    }

    private static Boolean enoughLengthToDivide(String rawExpression) {
        return rawExpression.length() >= minCustomDelimLength;
    }

    private static void assignCandidate(String rawExpression) {
        candidate = rawExpression.substring(0,minCustomDelimLength);
        System.out.println(candidate);
    }

    private static void assignRemainingPart(String rawExpression) {
        remainingPart = rawExpression.replace(candidate, "");
        onlyCustomDelimExistInRawExpression();
    }

    private static void onlyCustomDelimExistInRawExpression() {
        if(remainingPart.isEmpty()) {
            remainingPart = "0";
        }
    }

    public static UserExpression setDivideForCustomDelim() {
        userExpression.setCustomDelimExpressionCandidate(candidate);
        userExpression.setEssentialExpression(remainingPart);
        return userExpression;
    }

    public static UserExpression setDivideCustomDelimDisappear() {
        userExpression.setEssentialExpression(rawExpression);
        return userExpression;
    }
}
