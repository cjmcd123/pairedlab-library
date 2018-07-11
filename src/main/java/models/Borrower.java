package models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String name;
    private ArrayList<Book> itemsBorrowed;

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

    @OneToMany(mappedBy = "books")
    public ArrayList<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemsBorrowed(ArrayList<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }
}
