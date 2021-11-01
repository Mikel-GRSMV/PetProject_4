package ru.folder.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);
        String className = sc.next();
        Class aClass= Class.forName(className);

        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType());
        }

        Class types[] = new Class[fields.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = fields[i].getType();
        }
       // Object o = aClass.newInstance();
       // System.out.println(o);
        Constructor constructor = aClass.getDeclaredConstructor(types);
        for (Class parameterType : constructor.getParameterTypes()){
            System.out.println(parameterType.getName());
        }

        Integer intValue = 0;
        String stringValue = "";
        for (int i = 0; i < types.length; i++) {
            if (types[i].getName().equals("int")){
                 intValue = sc.nextInt();
            }else if (types[i].getName().equals("java.lang.String")){
                stringValue = sc.next();
            }
        }

        Object arguments[] = {intValue, stringValue};
        Object obj = constructor.newInstance(arguments);
        System.out.println(obj);
    }
}
