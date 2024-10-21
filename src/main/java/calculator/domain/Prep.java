package calculator.domain;

import java.util.Arrays;
import java.util.List;
import javax.lang.model.util.Elements;

public class Prep {

    private static List<String> diceElements (String input, String delimiter) {
        return Arrays.stream(input.split(delimiter)).toList();
    }

    public static List<Long> convertToNumbers(String input, String delimiter) {
        return diceElements(input, delimiter).stream().map(Long::parseLong).toList();
    }
}
