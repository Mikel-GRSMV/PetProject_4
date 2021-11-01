package ru.folder;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        SomeClass someObject = new SomeClass();

        Class someClassAsClass = someObject.getClass();


            Field someField = someClassAsClass.getField("someField");
            System.out.println("тип данных поля: " + someField.getType() + "\n" +
                               "имя поля: " + someField.getName() + "\n" +
                               "класс нашего поля: " + someField.getClass() + "\n");


        System.out.println("Array our Field:");
        Field[] fields = someClassAsClass.getFields();
        for (Field field : fields){
            System.out.println(field.getType() + field.getName());
        }

        System.out.println(someObject.someField);
        someField.set(someObject, 777);
        System.out.println(someObject.someField);

        Field privateField = someClassAsClass.getDeclaredField("somePrivateField");
        System.out.println("private field: " + privateField.getName());
        privateField.setAccessible(true);
        privateField.set(someObject, "Mike");
        System.out.println(someObject.getSomePrivateField());
    }
}
