package classWork;

public class A {
    int id;

    public A(int id) {
        this.id = id;
        System.out.println("Constructor 454class A");

    }



    @Override
    public String toString() {
        return "Class A";
    }

    public static void main(String[] args) {
//        boolean a = true;
//        boolean b = true;
//        Boolean aa = Boolean.valueOf("true");
//        Boolean bb = Boolean.TRUE;
//        Boolean cc = true;
//
//        System.out.println(a == b);
//        System.out.println(bb == cc);
//        System.out.println(aa == cc);
//
//        Character char1 = Character.valueOf('\u007F');
        Character char2 = 127;
        Character char3 = 127;

        System.out.println(char2 + " " + char3);
//        System.out.println(char1 == char2);
        System.out.println(char2 == char3);



    }
}
