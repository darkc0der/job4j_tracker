package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;
    private final Output out;

    public StubInput(String[] answers, Output out) {
        this.out = out;
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        out.println(question);
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
