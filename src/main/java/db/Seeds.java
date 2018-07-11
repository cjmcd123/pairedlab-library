package db;

import models.*;

public class Seeds {
    public static void seedData() {
        DBHelper.deleteAll(Object.class);

        Book book1 = new Book("Lord of the rings", "J.R.R Tolkien");
        DBHelper.save(book1);
        Book book2 = new Book("1984", "George Orwell");
        DBHelper.save(book2);
        Book book3 = new Book("Animal Farm", "George Orwell");
        DBHelper.save(book3);
        Book book4 = new Book("Fear and loathing in las vegas", "Hunter S. Thompson");
        DBHelper.save(book4);
        Book book5 = new Book("Letter to my fanny", "Cherry Healey");
        DBHelper.save(book5);

        Borrower borrower1 = new Borrower ("Bob");
        DBHelper.save(borrower1);

    }

}
