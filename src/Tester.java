import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {
    public static void start(Class c) {
        List<Method> methods = new ArrayList<>();
        Method[] classMethods = c.getDeclaredMethods();

        for (Method m : classMethods) {
            if (m.isAnnotationPresent(Test.class)) {
                methods.add(m);
            }
        }
        Collections.sort(methods, new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return -(m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority());
            }
        });

        for (Method m : classMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("BeforeSuite уже есть");
                }
                methods.add(0, m);
            }
        }

        for (Method m : classMethods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("AfterSuite уже есть");
                }
                methods.add(m);
            }
        }
        for (Method m: methods) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
