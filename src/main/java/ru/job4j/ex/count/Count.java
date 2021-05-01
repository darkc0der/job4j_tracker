package ru.job4j.ex.count;

public class Count {
    public static int add(int start, int finish) {
        if (start > finish) {
            throw new IllegalArgumentException("Start should be less them finish.");
        }
        int rsl = 0;
        for (int i = start; i != finish; i++) {
            rsl += i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Sum of 2 to 10 is : " + add(10, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Start should be less them finish.");
        }
    }
}
