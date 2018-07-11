package controllers;

import db.DBHelper;
import db.DBLibrary;
import models.Book;
import models.Borrower;
import models.Library;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookController {
    VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

    public BookController(){this.setupEndpoint();}

    private void setupEndpoint(){

        get("/books", (req, res)->{
            HashMap<String , Object> model = new HashMap<>();
            List<Book> books = DBHelper.getAll(Book.class);
            model.put("template", "templates/books/index.vtl");
            model.put("books", books);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        get("/books/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/create.vtl");
            List<Library> libraries = DBHelper.getAll(Library.class);
            Library library = libraries.get(0);
            model.put("linrary", library);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/:id", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Book book = DBHelper.find(id, Book.class);
            model.put("template", "templates/books/show.vtl");
            model.put("book", book);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/:id/edit", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Book book = DBHelper.find(id, Book.class);
            model.put("template", "templates/borrowers/edit.vtl");
            model.put("book", book);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/books", (req, res) -> {
            String title = req.queryParams("title");
            String author = req.queryParams("author");
            int id = Integer.parseInt(req.params("library"));
            Library library = DBHelper.find(id, Library.class);
            Book book = new Book(title, author, library);
            DBHelper.save(book);
            res.redirect("/books");
            return null;
        }, velocityTemplateEngine);

        post("/books/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Book book = DBHelper.find(id, Book.class);
            book.setTitle(req.queryParams("title"));
            book.setAuthor(req.queryParams("author"));
            int libraryid = Integer.parseInt(req.params("library"));
            Library library = DBHelper.find(libraryid, Library.class);
            book.setLibrary(library);
            DBHelper.save(book);
            res.redirect("/books");
            return null;
        }, velocityTemplateEngine);

        get("/books/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Book book = DBHelper.find(id, Book.class);
            DBHelper.delete(book);
            res.redirect("/books");
            return null;
        }, velocityTemplateEngine);

        get("/books/:id/rent", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Book book = DBHelper.find(id, Book.class);
            List<Borrower> borrowers = DBHelper.getAll(Borrower.class);
            model.put("template", "templates/books/rentpage.vtl");
            model.put("book", book);
            model.put("borrowers", borrowers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/books/:id/rent", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Book book = DBHelper.find(id, Book.class);
            int borrowerId = Integer.parseInt(req.queryParams("borrower"));
            Borrower borrower = DBHelper.find(borrowerId, Borrower.class);
            DBLibrary.borrow(borrower, book);
            res.redirect("/books");
            return null;
        }, velocityTemplateEngine);

    }
}
