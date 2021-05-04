package ru.job4j.shablons.abstractfactory;

public class ShapeFactory {
    private ShapeAbstractFactory factory;

    public ShapeFactory(ShapeAbstractFactory factory) {
        this.factory = factory;
    }

    public Shape create(String name) {
        Shape shape = factory.createEmpty();
        if ("triangle".equals(name)) {
            shape = factory.createTriangle();
        } else if ("rectangle".equals(name)) {
            shape = factory.createRectangle();
        }
        return shape;
    }

    public static void main(String[] args) {
        CreateShape shapes = new CreateShape();
        ShapeFactory f = new ShapeFactory(shapes);
        Shape shape = f.create("triangle");
        System.out.println(shape);

        shape = f.create("circle");
        System.out.println(shape);
        shape = f.create("rectangle");
        System.out.println(shape);
    }
}
