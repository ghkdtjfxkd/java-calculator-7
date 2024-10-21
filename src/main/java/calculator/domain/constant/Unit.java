package calculator.domain.constant;

public enum Unit {

    START(0),
    MIN_CUSTOM_DELIM_LENGTH(CustomDelimBracket.values().length);

    private final int value;

    Unit(int num) {
        value = num;
    }

    public int getValue() {
        return value;
    }
}
