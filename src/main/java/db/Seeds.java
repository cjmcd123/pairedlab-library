package db;

import models.Book;
import models.Borrower;
import models.Library;

public class Seeds {
    public static void seedData() {
        DBHelper.deleteAll(Object.class);

        Book book1 = new Book("Lord of the rings", "J.R.R Tolkien");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("Animal Farm", "George Orwell");
        Book book4 = new Book("Fear and loathing in las vegas", "Hunter S. Thompson");
        Book book5 = new Book("Letter to my fanny", "Cherry Healey");

        Borrower borrower1 = new Borrower("Jack");
        Borrower borrower2 = new Borrower("Craig");
        Borrower borrower3 = new Borrower("Debi");

        Library library = new Library("Clock Books");


}}
