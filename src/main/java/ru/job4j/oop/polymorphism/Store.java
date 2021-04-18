package ru.job4j.oop.polymorphism;

public interface Store {
    void save(String value);

    String[] load();
}
