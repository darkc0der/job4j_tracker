package ru.job4j.shablons.abstractfactory;

public class EmptyShape implements Shape {
    private String name = "Empty";

    @Override
    public String toString() {
        return "EmptyShape{"
                + "name='" + name + '\'' + '}';
    }
}
