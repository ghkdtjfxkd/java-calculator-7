package calculator.service;

import calculator.domain.UserExpression;
import calculator.domain.UserExpressionDivide;
import calculator.repository.DelimiterRepository;

public class ExpressionService {

    private UserExpression userExpression;
    private String rawExpression;
    private DelimiterRepository delimiterRepository;

    public ExpressionService(UserExpression userExpression, DelimiterRepository delimiterRepository) {
        this.userExpression = userExpression;
        rawExpression = userExpression.getRawExpression();
        this.delimiterRepository = delimiterRepository;
    }

//    public UserExpression divide() {
//        return UserExpressionDivide.complete(userExpression);
//    }
////
//    public UserExpression customDelimTreat () {
//        if(!userExpression.getEssentialExpression().isEmpty()) {
//            userExpression.getCustomDelimExpressionCandidate();
//        }
//    }


    private String unifyDelim () {
        return Unify.allDelimiters(userExpression.getEssentialExpression()
                        ,delimiterRepository.getDelimiters());
    }

}
