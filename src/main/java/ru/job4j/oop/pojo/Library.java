package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book classicBook = new Book("Classic", 10);
        Book detectiveBook = new Book("Detectiv", 5);
        Book fiction = new Book("Fiction", 20);
        Book thriller = new Book("Thriller", 50);
        Book cleanCode = new Book("CleanCode", 1);

        Book[] books = new Book[5];
        books[0] = classicBook;
        books[1] = detectiveBook;
        books[2] = fiction;
        books[3] = thriller;
        books[4] = cleanCode;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("CleanCode")) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }
    }
}
