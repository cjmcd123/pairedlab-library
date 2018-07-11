package db;

import models.Book;

public class Seeds {
    public static void seedData() {
        DBHelper.deleteAll(Object.class);

        Book book1 = new Book("Lord of the rings", "J.R.R Tolkien");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("Animal Farm", "George Orwell");
        Book book4 = new Book("Fear and loathing in las vegas", "Hunter S. Thompson");
        Book book5 = new Book("Letter to my fanny", "Cherry Healey");



}
