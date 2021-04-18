package ru.job4j.oop.polymorphism;

public class DbStore implements Store {
    public void save(String value) {
        System.out.println("Db Store");
    }

    public String[] load() {
        return new String[] {};
    }
}
