//package classWork;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
//public class A implements Comparable<A>{
//    int id;
//
//    private A() {
//        this.id = id;
//        System.out.println("Constructor 454class A");
//
//    }
//
//    private void method(String a) {
//
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "Class A";
//    }
//
//
//
//
//
//    }
//
//    @Override
//    public int compareTo(A a) {
//        return 0;
//    }
//}
//
//class Main {
//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
//   Class<?> a = Class.forName("A");
//        Constructor<A> c = (Constructor<A>) a.getDeclaredConstructor();
//        A b = (A) a.newInstance();
//        Method m = a.getDeclaredMethod("method", String.class);
//        m.setAccessible(true);
//        m.invoke(b, "Hello");
//        }
