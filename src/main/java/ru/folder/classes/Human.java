package ru.folder.classes;

public class Human {
    public int age;
    public String name;

//    public Human() {
//        this.age = 1;
//        this.name = "DEFAULT NAME";
//    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
