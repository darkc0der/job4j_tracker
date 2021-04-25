package ru.job4j.shablons.strategy;

public class Square implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "_________"  + ln
                + "|        |" + ln
                + "|        |" + ln
                + "|        |" + ln
                + "---------"  + ln;
    }
}
