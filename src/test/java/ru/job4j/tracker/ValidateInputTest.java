package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"one", "2"}, out);
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter name: ");
        assertThat(selected, is(2));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"5"}, out);
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter name: ");
        assertThat(selected, is(5));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1", "1"}, out);
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter name: ");
        assertThat(selected, is(1));
    }
}