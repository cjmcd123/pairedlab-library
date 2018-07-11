package db;



import models.*;


public class Seeds {
    public static void seedData() {
        DBHelper.deleteAll(Book.class);
        DBHelper.deleteAll(Borrower.class);
        DBHelper.deleteAll(Library.class);

        Library library = new Library("Codeclan Library");
        DBHelper.save(library);


        Book book1 = new Book("Lord of the rings", "J.R.R Tolkien", library);
        DBHelper.save(book1);
        Book book2 = new Book("1984", "George Orwell", library);
        DBHelper.save(book2);
        Book book3 = new Book("Animal Farm", "George Orwell", library);
        DBHelper.save(book3);
        Book book4 = new Book("Fear and loathing in las vegas", "Hunter S. Thompson", library);
        DBHelper.save(book4);
        Book book5 = new Book("Letter to my fanny", "Cherry Healey", library);
        DBHelper.save(book5);

        Borrower borrower1 = new Borrower ("Bob", library);
        DBHelper.save(borrower1);


    }


}
