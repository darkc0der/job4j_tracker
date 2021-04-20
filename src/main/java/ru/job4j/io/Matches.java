package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn  = true;
        String player = "";
        int count = 11;
        while (count > 0) {
            player = turn ? "Первый" : "Второй";
            System.out.println(player + " игрок введите число от 1 до 3:");
            int matches = Integer.valueOf(input.nextLine());
            if (matches >= 1 && matches <= 3) {
                count -= matches;
                turn = !turn;
                System.out.println("Спичек осталось на столе: " + count);
            } else {
                System.out.println("Не верный ввод");
            }
        }
        System.out.println(player + " игрок выиграл!");
    }
}
