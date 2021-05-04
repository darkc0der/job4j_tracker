package ru.job4j.shablons.factorymethod;
/* Фабричный метод */
public class ShapeFactory {
    public static Shape create(String name) {
        Shape shape = new EmptyShape();
        if ("triangle".equals(name)) {
            shape = new TriangleShape();
        } else if ("rectangle".equals(name)) {
            shape = new RectangleShape();
        }
        return shape;
    }

    public static void main(String[] args) {
        Shape shape = ShapeFactory.create("triangle");
        System.out.println(shape.toString());
        shape = ShapeFactory.create("cycle");
        System.out.println(shape);
        shape = ShapeFactory.create("rectangle");
        System.out.println(shape);
    }
}
