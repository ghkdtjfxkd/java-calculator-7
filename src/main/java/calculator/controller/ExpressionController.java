package calculator.controller;

import calculator.domain.CustomDelim;
import calculator.domain.CustomDelimVerify;
import calculator.domain.Prep;
import calculator.domain.UserExpression;
import calculator.domain.UserExpressionDivide;
import calculator.domain.Validation;
import calculator.repository.DelimiterRepository;
import calculator.service.Unify;
import java.util.List;

public class ExpressionController {

    private UserExpression userExpression;
    private DelimiterRepository delimiterRepository;

    public List<String> init(UserExpression userExpression) {
        this.userExpression = userExpression;
        delimiterRepository = new DelimiterRepository();
        divideUserExpression();
        customDelimProcess();
        String unified = unifyAllDelim(userExpression.getEssentialExpression(),
                delimiterRepository.getDelimiters());
        System.out.println(unified);
        System.out.println(delimiterRepository.getDelimiters());
        return prepExpressionDiced(unified);
    }

    private void customDelimProcess() {
        userExpression = UserExpressionDivide.setDivideCustomDelimDisappear();
        if(CustomDelimVerify.exist(userExpression.getCustomDelimExpressionCandidate())){
            customDelimTreatment(userExpression.getCustomDelimExpressionCandidate());
            userExpression = UserExpressionDivide.setDivideForCustomDelim();
        }
    }

    private void divideUserExpression() {
        UserExpressionDivide.dividePart(userExpression);
        userExpression = UserExpressionDivide.setDivideForCustomDelim();
    }

    private void customDelimTreatment(String customDelimCandidate) {
        delimiterRepository.addDelimiters(new CustomDelim(customDelimCandidate).getDelim());
    }

    private String unifyAllDelim(String essenceExpression, List<String> delimiters) {
        return Unify.allDelimiters(essenceExpression, delimiters);
    }

    private List<String> prepExpressionDiced(String unified) {
        Validation.undefinedStrMixedInExpression(unified,delimiterRepository.getDelimiters());
        return Prep.dicedChunk(unified, delimiterRepository.getDelimiters().getFirst());
    }

}
