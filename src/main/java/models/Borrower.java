package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String name;
    private Set<Book> itemsBorrowed;
    private Library library;

    public Borrower(){

    }

    public Borrower(String name, Library library) {
        this.name = name;
        this.library = library;
        this.itemsBorrowed = new HashSet<>();
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

    @OneToMany(mappedBy = "currentBorrower")
    public Set<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemsBorrowed(Set<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void borrow(Book book) {
        this.itemsBorrowed.add(book);
    }

    public void returnBook(Book book){
        this.itemsBorrowed.remove(book);
    }
}
