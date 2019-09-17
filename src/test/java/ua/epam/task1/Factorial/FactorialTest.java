package ua.epam.task1.Factorial;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FactorialTest {
    private int number;
    private long factorial;

    public FactorialTest(int number, long factorial) {
        this.number = number;
        this.factorial = factorial;
    }

    @Parameters public static Collection<Object[]> factorialTableValues() {
        return Arrays.asList( new Object[][] {
            { 0, 1 },
            { 5, 120 },
            { 12, 479_001_600},
            { 15, 1_307_674_368_000L}
        });
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void shouldReturnRightFactorialValuesWithFactRec() {
        long expected = this.factorial;
        long actual = Factorial.factRecursive(this.number);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightFactorialValuesWithFactLoops() {
        long expected = this.factorial;
        long actual = Factorial.factLoops(this.number);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnRightFactorialValuesWithFactBigNumbers() {
        BigInteger expected = BigInteger.valueOf(this.factorial);
        BigInteger actual = Factorial.factBigNumbers(this.number);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTwentiethFactorialWithFactBigNumbers() {
        BigInteger actual = Factorial.factBigNumbers(20);
        BigInteger expected = new BigInteger("2432902008176640000");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRuntimeExceptionWithValueMoreThanTwentyInFactLoops() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Invalid argument`s value");

        Factorial.factLoops(21);
    }

    @Test
    public void shouldThrowRuntimeExceptionWithValueMoreThanTwentyInFactRec() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Invalid argument`s value");

        Factorial.factRecursive(21);
    }

    @Test
    public void shouldThrowRuntimeExceptionWithValueLessThanZeroInFactLoops() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Invalid argument`s value");

        Factorial.factLoops(-1);
    }

    @Test
    public void shouldThrowRuntimeExceptionWithValueLessThanZeroInFactRec() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Invalid argument`s value");

        Factorial.factRecursive(-1);
    }
}