package ru.job4j.shablons.factorymethod;

public class RectangleShape extends Shape {
    private String name = "Rectangle";

    @Override
    public String toString() {
        return "RectangleShape{"
                + "name='" + name + '\'' + '}';
    }
}
