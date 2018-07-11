package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String name;
    private List<Book> itemsBorrowed;
    private Library library;

    public Borrower(){

    }

    public Borrower(String name, Library library) {
        this.name = name;
        this.library = library;
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
    public List<Book> getItemsBorrowed() {
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

    public void setItemsBorrowed(List<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
