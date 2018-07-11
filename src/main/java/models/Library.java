package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libraries")
public class Library {

    private int id;
    private String name;
    private List<Book> books;
    private List<Borrower> borrowers;

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

    @OneToMany(mappedBy = "library")
    public List<Book> getBooks() {
        return books;
    }

    @OneToMany(mappedBy = "library")
    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
}
