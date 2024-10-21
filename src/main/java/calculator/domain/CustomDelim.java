package calculator.domain;

public class CustomDelim {

    private static String candidate;
    private static Boolean status;
    private static String delim;

    public Boolean exist() {
        return status;
    }

    public CustomDelim(String input) {
        status = Boolean.FALSE;
        candidate = input;
    }

    public static String getCandidate() {
        return candidate;
    }

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        CustomDelim.status = status;
    }

    public static String getDelim() {
        return delim;
    }

    public static void setDelim(String delim) {
        CustomDelim.delim = delim;
    }
}
