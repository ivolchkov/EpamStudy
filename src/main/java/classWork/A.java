package classWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class A {
    int id;

    public A(int id) {
        this.id = id;
        System.out.println("Constructor class A");

    }

    public void method(String a) throws FileNotFoundException {

    }



    @Override
    public String toString() {
        return "Class A";
    }


}

//class Main {
//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
//   Class<?> a = Class.forName("A");
//        Constructor<A> c = (Constructor<A>) a.getDeclaredConstructor();
//        A b = (A) a.newInstance();
//        Method m = a.getDeclaredMethod("method", String.class);
//        m.setAccessible(true);
//        m.invoke(b, "Hello");
//        }
