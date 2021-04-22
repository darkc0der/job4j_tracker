package ru.job4j.oop;

public class GuineaPig implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " любит побегать в колесе.");
    }

    public void runInWheel() {

    }
}
