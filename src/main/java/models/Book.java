package models;

public class Book {

    private int id;
    private String title;
    private String author;
    private Boolean onLoan;
    private Borrower currentBorrower;

    public Book(){

    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.onLoan = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getOnLoan() {
        return onLoan;
    }

    public Borrower getCurrentBorrower() {
        return currentBorrower;
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
}
