package ru.job4j.shablons.strategy;

public class Paint {
    static void paint(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape tr = new Triangle();
        Shape sq = new Square();
        paint(tr);
        paint(sq);
    }
}
