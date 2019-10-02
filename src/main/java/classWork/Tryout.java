package classWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tryout {

    public static void main(String[] args) {
        String secondName = "165-65-49 sdf 125-35-79 12-58-65";
//        String regex = "(\\w{2,})@(\\w+\\p{Punct})([a-z]{2,5})";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(email);
//
//
//        while(matcher.find()) {
//            System.out.println("e-mail:" + matcher.group());
//        }
        String regex = "\\d{3}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(secondName);

        while(matcher.find()) {
            System.out.println("second name " + matcher.group());
        }

        switch(new Integer(4)) {
            case 4 : {
                System.out.println(4);
            }
        }
    }
}

//
//    public void shouldReturnZeroFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(0);
//        long expected = 0;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnZeroFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(0);
//        long expected = 0;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnZeroFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(0);
//        BigInteger expected = BigInteger.valueOf(0);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFirstFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(1);
//        long expected = 1;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFirstFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(1);
//        long expected = 1;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFirstFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(1);
//        BigInteger expected = BigInteger.valueOf(1);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFifthFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(5);
//        long expected = 5;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFifthFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(5);
//        long expected = 5;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFifthFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(5);
//        BigInteger expected = BigInteger.valueOf(5);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnTenthFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(10);
//        long expected = 55;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnTenthFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(10);
//        long expected = 55;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnTenthFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(10);
//        BigInteger expected = BigInteger.valueOf(55);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnMinusTenthFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(-10);
//        long expected = -55;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnMinusTenthFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(-10);
//        long expected = -55;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnMinusTenthFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(-10);
//        BigInteger expected = BigInteger.valueOf(-55);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFortySixthFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(46);
//        long expected = 1836311903;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFortySixthFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(46);
//        long expected = 1836311903;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFortySixthFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(46);
//        BigInteger expected = BigInteger.valueOf(1836311903);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnMinusFortySixthFibNumberWithFibLoops() {
//        long actual = Fibonacci.fibLoops(-46);
//        long expected = -1836311903;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnMinusFortySixthFibNumberWithFibRec() {
//        long actual = Fibonacci.fibRecursive(-46);
//        long expected = -1836311903;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnMinusFortySixthFibNumberWithFibBigNumbers() {
//        BigInteger actual = Fibonacci.fibBigNumbers(-46);
//        BigInteger expected = BigInteger.valueOf(-1836311903);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnZeroFactorialWithFactLoops() {
//        long actual = Factorial.factLoops(0);
//        long expected = 1;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnZeroFactorialWithFactRec() {
//        long actual = Factorial.factRecursive(0);
//        long expected = 1;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnZeroFactorialWithFactBigNumbers() {
//        BigInteger actual = Factorial.factBigNumbers(0);
//        BigInteger expected = BigInteger.valueOf(1);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFifthFactorialWithFactLoops() {
//        long actual = Factorial.factLoops(5);
//        long expected = 120;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFifthFactorialWithFactRec() {
//        long actual = Factorial.factRecursive(5);
//        long expected = 120;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnFifthFactorialWithFactBigNumbers() {
//        BigInteger actual = Factorial.factBigNumbers(5);
//        BigInteger expected = BigInteger.valueOf(120);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnTwelfthFactorialWithFactLoops() {
//        long actual = Factorial.factLoops(12);
//        long expected = 479_001_600;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnTwelfthFactorialWithFactRec() {
//        long actual = Factorial.factRecursive(12);
//        long expected = 479_001_600;
//
//        assertEquals(expected, actual);
//    }

