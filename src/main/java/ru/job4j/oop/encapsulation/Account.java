package ru.job4j.oop.encapsulation;

public class Account {
    private int balance;

    public void addMoney(int money) {
        if (money > 0) {
            balance += money;
        }
    }
}
