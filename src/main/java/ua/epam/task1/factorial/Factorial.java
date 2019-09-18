package ua.epam.task1.factorial;

import java.math.BigInteger;

public interface Factorial {
    static long factLoops(int n) {
        validate(n);

        long result = 1;

        if ( n == 0 ) {
            return 1;
        }

        for ( int i = 1; i <= n; i++ ) {
            result *= i;
        }

        return result;
    }

    static long factRecursive(int n) {
        validate(n);

        return n == 0 ? 1 : n * factRecursive(n-1);
    }

    static BigInteger factBigNumbers(int n) {
        validate(n);

        BigInteger result = BigInteger.valueOf(1);

        if ( n == 0 ) {
            return BigInteger.valueOf(1);
        }

        for ( int i = 1; i <= n; i++ ) {
            result = result.multiply(BigInteger.valueOf(Integer.toUnsignedLong(i)));
        }

        return result;
    }

    static void validate(int n) {
        if ( n > 20 || n < 0 ) {
            throw new RuntimeException("Invalid argument`s value");
        }
    }

}
