package ru.job4j.ex;

public class FactRec {
    public int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        FactRec fr = new FactRec();
        int i = fr.calc(0);
        System.out.println(i);
    }
}
