package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    private int id;
    private String title;
    private String author;
    private Boolean onLoan;
    private Borrower currentBorrower;
    private Library library;

    public Book(){

    }

    public Book(String title, String author, Library library) {
        this.title = title;
        this.author = author;
        this.onLoan = false;
        this.library = library;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    @Column(name = "onLoan")
    public Boolean getOnLoan() {
        return onLoan;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", nullable = true)
    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    @ManyToOne
    @JoinColumn(name = "libaray_id", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOnLoan(Boolean onLoan) {
        this.onLoan = onLoan;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void lend(Borrower borrower) {
        this.onLoan = true;
        this.currentBorrower = borrower;
    }

    public void returnBook(){
        this.onLoan = false;
        this.currentBorrower = null;
    }

    public boolean lendAble() {
        if (this.onLoan == false){
            return true;
        } return false;
    }
}
