package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.beregmira.SMSpring.service.ArticleService;
import ru.beregmira.SMSpring.service.UserAppService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserController {

    @Autowired
    private UserAppService userService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/user", params = {"id"}, method = GET)
    public String getSingleUser(Model model,
                                @RequestParam(value = "id") Long id) {
        model.addAttribute("SingleUser", userService.getSingleUser(id));
        model.addAttribute("CountArticles", articleService.countArticlesByUserId(id));
        return "SingleUser";
    }
}
