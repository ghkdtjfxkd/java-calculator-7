package calculator.domain;

import java.util.Optional;

public class UserExpression {

    private String rawExpression;
    private String customDelimExpressionCandidate;
    private String EssentialExpression;

    public UserExpression(String rawExpression) {
        this.rawExpression = rawExpression;
    }

    public String getRawExpression() {
        return rawExpression;
    }

    public void setCustomDelimExpressionCandidate(String customDelimExpressionCandidate) {
        this.customDelimExpressionCandidate = customDelimExpressionCandidate;
    }

    public void setEssentialExpression (String essentialExpression) {
        EssentialExpression = essentialExpression;
    }

    public String getCustomDelimExpressionCandidate() {
        return customDelimExpressionCandidate;
    }

    public String getEssentialExpression() {
        return EssentialExpression;
    }

}
