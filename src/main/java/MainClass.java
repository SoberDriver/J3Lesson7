import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {
    static TestClass object = new TestClass();

    public static void main(String[] args) {
    start(TestClass.class);
    }

    public static void start(Class testClass){
        Method[] methods = testClass.getDeclaredMethods();
        beforeSuitCheck(testClass);
        try {
            for (int i = 10; i > 0; i--) {
                for (Method meth : methods) {
                    if (meth.getAnnotation(Test.class) != null) {
                        Test test =
                                meth.getAnnotation(Test.class);

                        if (test.priority() == i) {
                            System.out.println(meth.invoke(object));
                            System.out.println("priority: " + test.priority());
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        afterSuitCheck(testClass);
    }

    public static void beforeSuitCheck(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        int beforeCount = 0;
        for (Method meth : methods) {
            if (meth.getAnnotation(BeforeSuit.class) != null) {
                if (beforeCount == 1) throw new RuntimeException();
                System.out.println(meth);
                beforeCount++;
            }
        }
    }

    public static void afterSuitCheck(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        int afterCount = 0;
        for (Method meth : methods) {
            if (meth.getAnnotation(AfterSuit.class) != null) {
                if (afterCount == 1) throw new RuntimeException();
                System.out.println(meth);
                afterCount++;

            }
        }
    }
}
