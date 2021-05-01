package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        int f = fact.calc(5);
        System.out.println("Factorial is : " + f);
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument is less than zero");
        }
        int rsl = 1;
        for (int i = 1; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
