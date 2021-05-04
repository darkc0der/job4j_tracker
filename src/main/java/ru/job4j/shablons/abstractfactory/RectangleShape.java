package ru.job4j.shablons.abstractfactory;

public class RectangleShape implements Shape {
    private String name = "Rectangle";

    @Override
    public String toString() {
        return "RectangleShape{"
                + "name='" + name + '\'' + '}';
    }
}
