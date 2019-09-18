package ua.epam.task1.fibonacci;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
//        long resultRecursive = Fibonacci.fibRecursive(30);
//        long resultLoops = Fibonacci.fibLoops(30);
        BigInteger resultBigInteger = Fibonacci.fibBigNumbers(199);

//        System.out.println("Recursive: " + resultRecursive);
//        System.out.println("Loops: " + resultLoops);
        System.out.println("Big Integer: " + resultBigInteger);

    }
}
