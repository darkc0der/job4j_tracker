package ru.job4j.ex;

import ru.job4j.ex.findel.ElementNotFoundException;

public class ElementAbuseException extends ElementNotFoundException {
    public ElementAbuseException(String message) {
        super(message);
    }
}
