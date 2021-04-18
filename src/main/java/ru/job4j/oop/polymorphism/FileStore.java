package ru.job4j.oop.polymorphism;

public class FileStore implements Store {

    @Override
    public void save(String value) {
        System.out.println("File Store");
    }

    @Override
    public String[] load() {
        return new String[0];
    }
}
