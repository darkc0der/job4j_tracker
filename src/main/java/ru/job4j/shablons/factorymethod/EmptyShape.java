package ru.job4j.shablons.factorymethod;

public class EmptyShape extends Shape {
    private String name = "Empty";

    @Override
    public String toString() {
        return "EmptyShape{"
                + "name='" + name + '\'' + '}';
    }
}
