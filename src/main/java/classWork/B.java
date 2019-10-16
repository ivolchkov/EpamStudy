package classWork;

import java.io.FileNotFoundException;
import java.io.IOException;

public class B extends A {
    private B() {
        super(0);
        System.out.println("Constructor class B");
    }

    @Override
    public String toString() {
        return "Class B";
    }

    public void method(String b) {

    }

    public static void main(String[] args) {
        B b = new B();

    }
}
