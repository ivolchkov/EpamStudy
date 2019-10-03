package ua.epam.task6.myJUnit;

public class TestClass {
    @BeforeClassMy
    public static  void staticInit(){
        System.out.println("Static");
    }

    @BeforeMy
    public void beforeInit() {
        System.out.println("Before init");
    }

    @AfterMy
    public void afterInit() {
        System.out.println("After init");
    }
    @TestMy
    public void shouldReturnResult1(){
        System.out.println("Result1");
    }

    @TestMy
    public void shouldReturnResult2(){
        System.out.println("Result2");
    }
}
