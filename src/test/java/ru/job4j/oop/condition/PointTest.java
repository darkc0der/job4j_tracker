package ru.job4j.oop.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void wen022to220Then28() {
        Point a = new Point(0, 2, 2);
        Point b = new Point(2, 2, 0);
        double rsl = a.distance3D(b);
        assertThat(rsl, closeTo(2.828, 0.001));
    }

    @Test
    public void when110to223Then33() {
        Point a = new Point(1, 1, 0);
        Point b = new Point(2, 2, 3);
        double rsl = a.distance3D(b);
        assertThat(rsl, closeTo(3.3166, 0.001));
    }
}