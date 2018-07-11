package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class BookController {
    VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

    public BookController(){this.setupEndpoint();}

    private void setupEndpoint(){

        get("/books", (req, res)->{
            HashMap<String , Object> model = new HashMap<>();
            List<Book> books = DBHelper.getAll(Book.class);
            model.put("template", "templates/book/index.vtl");
            model.put("books", books);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/:id", (req, res)-> {
            String strId = req.params(":id");
            int bookId = Integer.parseInt(strId);
            Book bookView = DBHelper.find(bookId, Book.class);
            HashMap<String , Object> model = new HashMap<>();
            model.put("book", bookView);
            model.put("template", "templates/book/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }
}
