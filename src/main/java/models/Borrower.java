package models;

import java.util.ArrayList;

public class Borrower {

    private int id;
    private String name;
    private ArrayList<Book> itemsBorrowed;

    public Borrower(){

    }

    public Borrower(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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
