package calculator.domain;

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

    public void setDivideValues (String candidate, String essential) {
        customDelimExpressionCandidate = candidate;
        EssentialExpression = essential;
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
