package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.beregmira.SMSpring.model.UserApp;
import ru.beregmira.SMSpring.service.ArticleService;
import ru.beregmira.SMSpring.service.CommentsService;
import ru.beregmira.SMSpring.service.UserAppService;

@Controller
public class MainController {
    @Autowired
    private UserAppService userAppService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentsService commentsService;

    //    TODO fix hardcode role in main.html
    @RequestMapping(value = "/main")
    public String mainBlogPage(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        UserApp userApp = userAppService.getUserAppByName(currentUser.getUsername());
        model.addAttribute("articles", articleService);
        model.addAttribute("users", userAppService);
        model.addAttribute("userApp", userApp);
        model.addAttribute("countCommentsByArticle", commentsService);
        return "main";
    }
}
