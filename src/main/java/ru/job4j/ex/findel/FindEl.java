package ru.job4j.ex.findel;

import ru.job4j.ex.ElementAbuseException;
import ru.job4j.ex.findel.ElementNotFoundException;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (int i = 0; i < abuses.length; i++) {
            if (abuses[i].equals(value)) {
                throw new ElementAbuseException("Element Abuses exception");
            }
        }
        return true;
    }

    public static void process(String[] value, String key, String[] abuses) {
        try {
            if (indexOf(value, key) != -1) {
                System.out.println(sent(key, abuses));
            }
        } catch (ElementAbuseException eae) {
            eae.printStackTrace();
        } catch (ElementNotFoundException enfe) {
            enfe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] abuses = {"this", "try", "catch", "Pavel"};
        String[] value = {"Fedya", "Ivan", "Nadya"};
        process(value, "Fedya", abuses);
    }
}
