package ua.epam.task3.lambda;

public class Main {
    public static void main(String[] args) {
        FuncInterface funcInterface = new FuncInterface() {
            @Override
            public int func(int n) {
                int result = 1;

                for (int i = 1; i <= n; i++ ) {
                    result *= i;
                }

                return result;
            }
        };

        FuncInterface lambdaInterface = (n) -> {
            int result = 1;

            for (int i = 1; i <= n; i++ ) {
                result *= i;
            }

            return result;
        };

        FuncInterface lambdaSquare = (n) -> n * n;

        System.out.println(funcInterface.func(5));
        System.out.println("Lambda: " + lambdaInterface.func(6));
        System.out.println("Lambda2: " + lambdaSquare.func(6));

    }
}
