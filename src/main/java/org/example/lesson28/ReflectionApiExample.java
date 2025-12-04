package org.example.lesson28;

import com.sun.jdi.LongValue;

import java.lang.reflect.*;
import java.lang.reflect.Modifier;


public class ReflectionApiExample {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = new User(25L, "Ivan");
//        testFields(user);
        testMethod(user);
//        Class<? extends User> userClass = user.getClass();
//        Class<User> userClass1 = User.class;
//        System.out.println(userClass == userClass1);
        testConstructor();
    }

    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       Constructor<User> constructor= User.class.getConstructor(Long.class, String.class);
        User petr = constructor.newInstance(5L, "Petr");
        System.out.println(petr);
    }

    private static void testFields(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getSuperclass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(object);
            System.out.println(declaredField.getModifiers());
            // [0, 0, 0, 0, 0, 0, 1, 1]
            System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
            System.out.println(value);
        }
    }

    private static void testMethod(User user) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method method = user.getClass().getDeclaredMethod("setName", String.class);
        method.invoke(user, "Sveta");
        System.out.println(user);
    }

    private class Test1{
    }

    private static class Test3{

    }
    private enum Test2{
        ONE, TWO
    }
}

// с помощью Reflection Api можно получить любую информацию про классы, все описание,которое мы добавили в эти классы
//(методы, поля, конструкторы, вложенные, внутренние классы, все их модификааторы доступа, реализованные интерфейсы,
// наследованные классы, абстрактный он или нет и тд)