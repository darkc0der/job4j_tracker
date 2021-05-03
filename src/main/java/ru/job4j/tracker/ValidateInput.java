package ru.job4j.tracker;
/* ValidateInput - class Decorator добавляет функционал уже существующим классам
 ConsoleInput and StubInput добавляя валидацию входных данных и реализуюя базовый
 интерфейс Input */

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String askStr(String question) {
        return input.askStr(question);
    }

    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
                String rsl = input.askStr(question);
                if (!isNumber(rsl)) {
                    output.println("Please enter validate data again.");
                    continue;
                }
                value = Integer.parseInt(rsl);
                invalid = false;
        } while (invalid);
        return value;
    }

    private boolean isNumber(String value) {
        boolean rsl = true;
        char[] check = value.toCharArray();
        for (char num : check) {
            if (num < 48 || num > 57) {
                rsl = false;
            }
        }
        return rsl;
    }
}
