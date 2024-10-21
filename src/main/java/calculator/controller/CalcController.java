package calculator.controller;

import calculator.domain.Calc;
import calculator.domain.Prep;
import calculator.domain.Validation;
import calculator.repository.NumberRepository;
import java.util.List;

public class CalcController {

    private Calc calc;
    private NumberRepository numberRepository;

    public void init(List<String> prepExpression) {
        createNewCalc();
        receiveData(prepExpression);
        calcTheNumbers();
    }

    private void createNewCalc() {
        calc = new Calc();
        numberRepository = new NumberRepository();
    }

    public void receiveData(List<String> dicedExpression) {
        numberRepository.save(prepToCalc(dicedExpression));
    }

    private List<Long> prepToCalc(List<String> dicedExpression) {
        List<Long> inputNums = Prep.convertToNumbers(dicedExpression);
        checkingNumbers(inputNums);
        return inputNums;
    }

    private void checkingNumbers (List<Long> numbers) {
        Validation.overTheLongRangeNumberElements(numbers);
    }

    public Long calcTheNumbers() {
        calc.sumAllNumbers(numberRepository.getNumbers());
        checkingResult();
        return calc.getValue();
    }

    private void checkingResult() {
        Validation.overFlowOccurInLongValue(calc.getValue());
    }
}
