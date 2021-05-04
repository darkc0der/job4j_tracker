package ru.job4j.shablons.abstractfactory;

public class TriangleShape implements Shape {
    private String name = "Triangle";

    @Override
    public String toString() {
        return "TriangleShape{"
                + "name='" + name + '\'' + '}';
    }
}
