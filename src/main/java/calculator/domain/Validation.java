package calculator.domain;


import calculator.repository.BasicDelimiters;
import calculator.repository.DelimiterRepository;
import java.util.List;

public class Validation {

//    public static void undefinedStrMixedInExpression (UserExpression expression, DelimiterRepository delimRepository) {
//        List<String> chars = List.of(expression.getEssentialExpression().split(""));
//        if(chars.stream()
//                    .filter(s -> s.matches("[0-9]"))
//                    .count()
//                + chars.stream()
//                    .filter(s -> s.matches(delimRepository.getDelimiters().getFirst()))
//                    .count()
//                != chars.size())
//        {throw new IllegalArgumentException();}
//    }

    public static void undefinedStrMixedInExpression (String unified, List<String> delimiters) {
        System.out.println("input unified: " + unified);
        List<String> chars = List.of(unified.split(""));
        if(chars.stream()
                    .filter(s -> s.matches("[0-9]"))
                    .count()
                + chars.stream()
                    .filter(s -> s.matches(delimiters.getFirst()))
                    .count()
                != chars.size())
        {throw new IllegalArgumentException();}
    }


    public static void overTheLongRangeNumberElements (List<Long> numbers) {
        for (Long number : numbers) {
            if(number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void overFlowOccurInLongValue(Long value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }
    }
}
