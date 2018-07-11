package models;

import java.util.ArrayList;

public class Library {

    private int id;
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;

    public Library(){

    }

    public Library(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setBorrowers(ArrayList<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
}
