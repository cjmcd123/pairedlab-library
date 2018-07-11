package models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "libraries")
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

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "book_id", nullable = true)
    public ArrayList<Book> getBooks() {
        return books;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "borrower_id", nullable = true)
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
