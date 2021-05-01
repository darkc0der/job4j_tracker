package ru.job4j.ex;

import org.junit.Test;
import ru.job4j.ex.fact.Fact;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeOne() {
        Fact fact = new Fact();
        fact.calc(-1);
    }
}