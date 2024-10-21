package calculator.repository;

public enum BasicDelimiters {

    COMMA(","), // 구분자 통일, 검증 시 기준이 되는 구분자

    COLON(":");

    private String delimiter;

    BasicDelimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    public String toString() {
        return delimiter;
    }
}
