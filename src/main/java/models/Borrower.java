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

    public Borrower(){

    }

    public Borrower(String name) {
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

    @OneToMany(mappedBy = "currentBorrower")
    public List<Book> getItemsBorrowed() {
        return itemsBorrowed;
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
}
