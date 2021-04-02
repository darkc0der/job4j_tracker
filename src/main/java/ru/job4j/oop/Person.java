package ru.job4j.oop;

public class Person {
    private String name;
    private int age;
    private double weight;

    public Person() {

    }

    public Person(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void show() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Вес: " + weight);
        System.out.println();
    }

    public static void main(String[] args) {
        Person vasya = new Person("Василий", 23, 120);
        Person victor = new Person("Виктор", 30, 80);

        vasya.show();
        victor.show();
    }
}
