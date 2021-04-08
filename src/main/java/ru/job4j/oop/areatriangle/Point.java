package ru.job4j.oop.areatriangle;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return sqrt(pow(this.x - point.x, 2) + pow(this.y - point.y, 2));
    }
}
