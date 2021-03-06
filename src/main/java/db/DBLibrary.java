package db;


import models.Book;
import models.Borrower;

public class DBLibrary {



    public static void borrow(Borrower borrower, Book book){
        if (book.lendAble()) {
            borrower.borrow(book);
            book.lend(borrower);
            DBHelper.save(book);
        }
    }

    public static void returnBook(Borrower borrower, Book book){
        borrower.returnBook(book);
        book.returnBook();
        DBHelper.save(book);
    }

}
