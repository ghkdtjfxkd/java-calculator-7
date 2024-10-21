package calculator.controller;

import calculator.domain.UserExpression;
import calculator.service.InputService;
import calculator.view.Users;

public class InputController {

    private static InputService inputService;

    public static void init() {
        inputService = new InputService();
        input();
        System.out.println(UserExpression.getRawExpression());
    }

    private static void input() {
        String newInput = Users.input();
        inputService.comesNewInput(newInput);
    }
}
