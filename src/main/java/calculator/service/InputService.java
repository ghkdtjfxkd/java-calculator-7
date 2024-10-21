package calculator.service;

import calculator.domain.UserExpression;
import calculator.view.Users;

public class InputService {

    private static UserExpression userExpression;

    public void comesNewInput(String input) {
        String converted = filterVacantInput(input);
        userExpression = new UserExpression(converted);
    }

    private String filterVacantInput(String input) {
        return input.isEmpty() ? "0" : input;
    }
}
