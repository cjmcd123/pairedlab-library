package controllers;

import db.*;
import models.*;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

//        staticFileLocation("/public");


        VelocityTemplateEngine velocityTemplateEngine =new VelocityTemplateEngine();
        BookController bookController =new BookController();
        BorrowerController borrowerController = new BorrowerController();
        Seeds.seedData();


    }

}
