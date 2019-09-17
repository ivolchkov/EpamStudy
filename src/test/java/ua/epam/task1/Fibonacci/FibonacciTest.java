package ua.epam.task1.Fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FibonacciTest {
    private int number;
    private long fibonacci;

    public FibonacciTest(int number, long fibonacci) {
        this.number = number;
        this.fibonacci = fibonacci;
    }

    @Parameters public static Collection<Object[]> fibTableValues() {
        return Arrays.asList( new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 5, 5 },
                { 10, 55 },
                { -10, -55 },
                { 46, 1836311903 },
                { -46, -1836311903}

        });
    }

    @Test
    public void shouldReturnRightFibValuesWithFibRec() {
        long expected = this.fibonacci;
        long actual = Fibonacci.fibRecursive(this.number);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightFibValuesWithFibLoops() {
        long expected = this.fibonacci;
        long actual = Fibonacci.fibLoops(this.number);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnRightFibValuesWithFibBigNumbers() {
        BigInteger expected = BigInteger.valueOf(this.fibonacci);
        BigInteger actual = Fibonacci.fibBigNumbers(this.number);

        assertEquals(expected, actual);
    }

}