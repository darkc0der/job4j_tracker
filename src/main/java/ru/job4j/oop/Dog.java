package ru.job4j.oop;

public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " не любит кошек, постоянно за ними гоняется.");
    }

    public void runAfterCat() {

    }
}
