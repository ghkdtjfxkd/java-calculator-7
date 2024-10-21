package calculator.service;

import calculator.domain.CustomDelim;
import calculator.domain.CustomDelimVerify;
import calculator.domain.UserExpression;
import calculator.domain.constant.CustomDelimBracket;

public class CustomDelimService {

    private String coveredDelim;

    public CustomDelimService(String candidate) {
        if(CustomDelimVerify.coveredBracket(candidate)) {
            coveredDelim = candidate;
        }
    }

    public String extractDelimiter() {
            hatchBracket(CustomDelimBracket.OPEN.get());
            hatchBracket(CustomDelimBracket.CLOSE.get());
            return coveredDelim;
    }

    private void hatchBracket(String bracket) {
        coveredDelim = coveredDelim.replace(bracket, "");
    }

}

