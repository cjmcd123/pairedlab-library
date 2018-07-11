package controllers;

import db.*;
import models.*;
import spark.template.velocity.VelocityTemplateEngine;

public class MainController {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine =new VelocityTemplateEngine();
        BookController bookController =new BookController();
        Seeds.seedData();


    }

}
