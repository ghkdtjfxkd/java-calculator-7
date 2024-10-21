package calculator.domain;

public class CustomDelim {

    private String candidate;
    private String delim;

    public CustomDelim(String input) {
        candidate = input;
        delim = CustomDelimExtract.getEssence(candidate);
    }

    public String getDelim() {
        return delim;
    }

}
