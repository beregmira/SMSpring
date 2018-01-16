package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.beregmira.SMSpring.service.ArticleService;
import ru.beregmira.SMSpring.service.UserAppService;

@Controller
@RequestMapping()
public class MainController {
    @Autowired
    private UserAppService userAppService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/main")
    public String mainBlogPage(Model model) {
        model.addAttribute("articles", articleService.getAll());
        model.addAttribute("users", userAppService.getAll());
        return "main";
    }
}
