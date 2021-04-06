package ru.job4j.oop.battery;
/* 1.7. Состояние объекта [#393907] */

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(100);
        Battery second = new Battery(0);
        System.out.println("Battery first: " + first.load + ". battery second: " + second.load);
        first.exchange(second);
        System.out.println("Battery first: " + first.load + ". battery second: " + second.load);
    }
}
