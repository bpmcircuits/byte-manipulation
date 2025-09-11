package com.bpm.kodilla.bytecode.reflection;

import com.bpm.kodilla.bytecode.reflection.domain.Book;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Book> descriptor = Book.class;
        for (Method method : descriptor.getMethods()) {
            System.out.println(method.getName());
        }

        int modifiers = descriptor.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);

        System.out.println(isPublic);
        System.out.println(isAbstract);

        Constructor<Book> constructor = descriptor.getConstructor(new Class[]{String.class, String.class, int.class});
        Book book = constructor.newInstance("Thinking in Java", "123/456", 2000);
        System.out.println(book.getTitle());
    }
}
