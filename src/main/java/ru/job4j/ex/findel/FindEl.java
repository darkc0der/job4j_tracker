package ru.job4j.ex.findel;

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

    public static void main(String[] args) {
        int index;
        try {
            index = indexOf(new String[]{"Ivan", "Pavel", "Nadya"}, "Nadya");
            if (index == 2) {
                System.out.println("Index of found element is : " + index);
            }
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
