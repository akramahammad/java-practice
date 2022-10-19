package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionAPI {

    public static void main(String[] args) {
        try {
            Class test=Class.forName(Test.class.getName());
            Constructor[] constructors = test.getConstructors();
            System.out.println(test.getName());
            System.out.println(Arrays.toString(test.getMethods()));
            Constructor c1=test.getConstructor(null);
            System.out.println(c1.newInstance(null));
            Constructor c2=test.getConstructor(int.class,int.class);
            Object test1=c2.newInstance(5,10);
            Method m1= test.getMethod("getMessage",null);
            System.out.println(m1.invoke(test1,null));
            Field f1 = test.getDeclaredField("t1");
            f1.setAccessible(true);
            f1.set(test1,50);
            Method m2= test.getMethod("getT1",null);
            System.out.println(m2.invoke(test1,null));
            Annotation[] annotations = test.getAnnotations();
            System.out.println(Arrays.toString(annotations));
            MyAnnotation annotation= (MyAnnotation) annotations[0];
            System.out.println(annotation.value());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
