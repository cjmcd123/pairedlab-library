package controllers;

import db.DBHelper;
import models.Borrower;
import models.Library;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class BorrowerController {

    public BorrowerController(){
        this.setUpEndPoints();
    }

    private void setUpEndPoints(){

        get("/borrowers", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/borrowers/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/borrowers/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/borrowers/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/borrowers/:id", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Borrower borrower = DBHelper.find(id, Borrower.class);
            model.put("template", "templates/borrowers/show.vtl");
            model.put("borrower", borrower);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/borrowers/:id/edit", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Borrower borrower = DBHelper.find(id, Borrower.class);
            model.put("template", "templates/borrowers/edit.vtl");
            model.put("borrower", borrower);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/borrowers", (req, res) -> {
            String name = req.queryParams("name");
            int id = Integer.parseInt(req.params(":id"));
            Library library = DBHelper.find(id, Library.class);
            Borrower borrower = new Borrower(name, library);
            DBHelper.save(borrower);
            res.redirect("/borrowers");
            return null;
        }, new VelocityTemplateEngine());

        post("/borrowers/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Borrower borrower = DBHelper.find(id, Borrower.class);
            borrower.setName(req.queryParams("name"));
            int libraryid = Integer.parseInt(req.params("library"));
            Library library = DBHelper.find(libraryid, Library.class);
            borrower.setLibrary(library);
            DBHelper.save(borrower);
            res.redirect("/borrowers");
            return null;
        }, new VelocityTemplateEngine());

        get("/borrowers/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Borrower borrower = DBHelper.find(id, Borrower.class);
            DBHelper.delete(borrower);
            res.redirect("/borrowers");
            return null;
        }, new VelocityTemplateEngine());

    }
}
