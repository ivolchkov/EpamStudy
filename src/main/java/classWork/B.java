package classWork;

public class B extends A {
    private B() {
        super(0);
        System.out.println("Constructor class B");
    }

    @Override
    public String toString() {
        return "Class B";
    }

    public static void main(String[] args) {
        B b = new B();

    }
}
