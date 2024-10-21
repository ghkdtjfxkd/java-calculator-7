package calculator.service;

import calculator.repository.DelimiterRepository;
import java.util.List;

public class Unify {

    private static String expression;
    private static List<String> delimiters;

    private Unify(String input, List<String> delims) {
        expression = input;
        delimiters = delims;
    }

    private static void initSetting(String expression, List<String> delimiters) {
        new Unify(expression, delimiters);
    }

    public static String allDelimiters (String expression, List<String> delimiters) {
        initSetting(expression, delimiters);
        for (String delimiter : delimiters) {
            expression = unifyDelimiter(delimiter);
        }
        return expression;
    }

    private static String unifyDelimiter (String delimiter) {
        return expression.replace(delimiter,delimiters.getFirst());
    }
}
