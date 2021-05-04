package ru.job4j.shablons.abstractfactory;

import ru.job4j.shablons.abstractfactory.Shape;

public interface ShapeAbstractFactory {

    Shape createTriangle();

    Shape createRectangle();

    Shape createEmpty();
}
