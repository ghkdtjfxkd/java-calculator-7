package calculator.domain.constant;

public enum Unit {

    START(0),
    MIN_CUSTOM_DELIM_LENGTH(CustomDelimBracket.OPEN.get().length()
            + CustomDelimBracket.CLOSE.get().length()
            +1 );

    private final int value;

    Unit(int num) {
        value = num;
    }

    public int getValue() {
        return value;
    }
}
