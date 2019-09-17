package ua.epam.task1.Factorial;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger resultBigInteger = Factorial.factBigNumbers(5);
        long resultRecursive = Factorial.factRecursive(1);
        long resultLoops = Factorial.factLoops(20);

        System.out.println("Big Integer: " + resultBigInteger);
        System.out.println("Recursive: " + resultRecursive);
        System.out.println("Loops: " + resultLoops);
    }
}
