package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.beregmira.SMSpring.model.Article;
import ru.beregmira.SMSpring.service.ArticleService;
import ru.beregmira.SMSpring.service.UserAppService;

@Controller
public class EditorController {
    @Autowired
    private ArticleService service;

    @Autowired
    private UserAppService userAppService;

    @RequestMapping(value = "/editor")
    public String editorPage(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        model.addAttribute("article", new Article());
        model.addAttribute("CurrentUserAppId", userAppService.getUserAppIdByCurrentUserName(currentUser));
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Article article) {
        service.save(article);
        return "redirect:../";
    }
}
