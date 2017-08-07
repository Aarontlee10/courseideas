package com.courseideas;
import static spark.Spark.*;
import java.util.*;
import com.courseideas.model.CourseIdea;
import com.courseideas.model.CourseIdeasDAO;
import com.courseideas.model.SimpleCourseIdeasDAO;
import spark.ModelAndView;
import spark.template.handlebars.*;
/**
 * Created by Aarontlee10 on 7/7/17.
 */
public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        CourseIdeasDAO dao = new SimpleCourseIdeasDAO();

        get("/",  (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username", username);
            model.put("username", username);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/ideas", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("ideas", dao.findAll());
            return new ModelAndView(model, "ideas.hbs");
        }, new HandlebarsTemplateEngine());

        post("/ideas", (req, res) -> {
            String title = req.queryParams("title");
            CourseIdea courseIdea = new CourseIdea(title,
                    req.cookie("username"));
            dao.add(courseIdea);
            res.redirect("/ideas");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
