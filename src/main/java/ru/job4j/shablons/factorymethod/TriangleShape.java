package ru.job4j.shablons.factorymethod;

public class TriangleShape extends Shape {
    private String name = "Triangle";

    @Override
    public String toString() {
        return "TriangleShape{"
                + "name='" + name + '\'' + '}';
    }
}
