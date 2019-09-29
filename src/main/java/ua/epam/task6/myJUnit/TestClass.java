package ua.epam.task6.myJUnit;

public class TestClass {
    @BeforeClass
    public static  void staticInit(){
        System.out.println("Static");
    }

    @Before
    public void beforeInit() {
        System.out.println("Before init");
    }

    @After
    public void afterInit() {
        System.out.println("After init");
    }
    @Test
    public void shouldReturnResult1(){
        System.out.println("Result1");
    }

    @Test
    public void shouldReturnResult2(){
        System.out.println("Result2");
    }
}
