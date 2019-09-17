package ua.epam.task1.Fibonacci;

import java.math.BigInteger;

public interface Fibonacci {
    static long fibRecursive(int n) {
        if ( n == 0 ) return 0;

        if ( n > 0 ) {
            if ( n == 1) return 1;

            return fibRecursive(n-1) + fibRecursive(n-2);
        }

        if ( n == -1 ) return 1;

        return fibRecursive(n+2) - fibRecursive(n+1);
    }

    static long fibLoops(int n) {
        boolean isPair = false;
        long result = 1;
        long buffer = 0;

        if ( n == 0 ) return 0;

        if ( n < 0 ) {
            isPair = n % 2 == 0;
            n *= -1;
        }

        for (int i = 1; i < n; i++ ) {
            long temp = result + buffer;
            buffer = result;
            result = temp;
        }

        if ( isPair ) {
            result *= -1;
        }

        return result;

    }

    static BigInteger fibBigNumbers(int n) {
        boolean isPair = false;
        BigInteger result = BigInteger.valueOf(1);
        BigInteger buffer = BigInteger.valueOf(0);

        if (n == 0) {
            result = BigInteger.valueOf(0);
        } else {
            if (n < 0) {
                isPair = n % 2 == 0;
                n *= -1;
            }
            for (int i = 1; i < n; i++) {
                BigInteger temp = result.add(buffer);
                buffer = result;
                result = temp;
            }
            if (isPair) {
                result = result.multiply(BigInteger.valueOf(-1));
            }
        }

        return result;
    }


}
