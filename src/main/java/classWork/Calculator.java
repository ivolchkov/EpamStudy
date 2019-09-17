package classWork;



public final class Calculator {
    private Calculator() {
        throw new RuntimeException("utility class");
    }

    public static int calc1(int arg1, String operator, int arg2) {
        if ( "+".equals(operator) ) {
            return arg1 + arg2;
        }
        if( "-".equals(operator) ) {
            return arg1 - arg2;
        }

        if ( "/".equals(operator) ) {
            return arg1 / arg2;
        }

        if ( "*".equals(operator) ) {
            return arg1 * arg2;
        } else {
            throw new RuntimeException("Invalid operator");
        }
    }

    public static int calc2(int arg1, String operator, int arg2) {
        if ( operator == null ) {
            throw new RuntimeException("Null");
        }

        switch (operator) {
            case "+" : return arg1 + arg2;
            case "-" : return arg1 - arg2;
            case "*" : return arg1 * arg2;
            case "/" : return arg1 / arg2;
            default: throw new RuntimeException("Invalid operator");
        }

    }
}
