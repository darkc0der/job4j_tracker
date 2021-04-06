package ru.job4j.oop;
/* 1.4. Вызов метода с возвращаемым типом. [#393906] */

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic dd = new DummyDic();
        String word = dd.engToRus("Hello world!");
        System.out.println(word);
    }
}
