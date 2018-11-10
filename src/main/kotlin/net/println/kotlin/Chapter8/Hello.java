package net.println.kotlin.Chapter8;

import java.lang.reflect.InvocationTargetException;

public class Hello {
    public static void main(String[] arg) {
        try {
            //调用静态方法使用invoke， null,不是静态使用实例
            JavaReflectionsKt.class.getDeclaredMethod("sayHello", Person.class).invoke(null,new Person("tommy",18));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
