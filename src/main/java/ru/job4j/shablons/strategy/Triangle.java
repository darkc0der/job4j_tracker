package ru.job4j.shablons.strategy;

public class Triangle implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "     ^ "     + ln
                + "   /   \\"   + ln
                + "  /     \\"  + ln
                + " /_______\\" + ln;
    }
}
