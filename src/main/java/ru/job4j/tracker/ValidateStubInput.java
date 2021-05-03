package ru.job4j.tracker;

public class ValidateStubInput extends StubInput {
    private Output output;

    public ValidateStubInput(String[] answers, Output out) {
        super(answers, out);
        this.output = out;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
           try {
               value = super.askInt(question);
               invalid = false;
           } catch (NumberFormatException e) {
               output.println("Please enter validate data again.");
           }
        } while (invalid);
        return value;
    }
}
