package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.beregmira.SMSpring.service.ArticleService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping()
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/blog", params = {"id"}, method = GET)
    public String getSingleArticle(Model model,
                                   @RequestParam(value = "id") int id){
        model.addAttribute("SingleArticle", articleService.getSingleArticle(id));
        return "SingleArticle";
    }
}