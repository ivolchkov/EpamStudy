package ua.epam.task6.myJUnit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class Runner {
    private Runner() {
    }

    public static void run() throws InvocationTargetException,
            IllegalAccessException {
        TestClass testClass = new TestClass();
        Class<?> clazz = testClass.getClass();
        Method[] methods = clazz.getMethods();

        List<Method> beforeClassMethods = getMethodByAnnotation(methods, BeforeClass.class);
        List<Method> afterClassMethods = getMethodByAnnotation(methods, AfterClass.class);
        List<Method> testMethods = getMethodByAnnotation(methods, Test.class);
        List<Method> beforeMethods = getMethodByAnnotation(methods, Before.class);
        List<Method> afterMethods = getMethodByAnnotation(methods, After.class);

        invokeMethods(beforeClassMethods, null);
        invokeTestMethods(beforeMethods, testMethods, afterMethods,testClass);
        invokeMethods(afterClassMethods, null);
    }

    private static void invokeTestMethods(List<Method> beforeMethods, List<Method> testMethods, List<Method> afterMethods, Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : testMethods) {
            invokeMethods(beforeMethods, object);
            method.invoke(object);
            invokeMethods(afterMethods, object);
        }
    }

    private static void invokeMethods(List<Method> beforeClassMethods, Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : beforeClassMethods) {
            method.invoke(object);
        }
    }


    private static List<Method> getMethodByAnnotation(Method[] methods, Class<? extends Annotation> clazz) {
        List<Method> resultMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(clazz)) {
                resultMethods.add(method);
            }
        }
        return resultMethods;
    }

}

class Main {
    public static void main(String[] args) throws Exception {
        Runner.run();
    }
}
