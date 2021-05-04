package ru.job4j.shablons.abstractfactory;

public class CreateShape implements ShapeAbstractFactory {

    @Override
    public Shape createTriangle() {
        return new TriangleShape();
    }

    @Override
    public Shape createRectangle() {
        return new RectangleShape();
    }

    @Override
    public EmptyShape createEmpty() {
        return new EmptyShape();
    }
}
