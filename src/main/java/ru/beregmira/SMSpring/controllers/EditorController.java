package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.beregmira.SMSpring.model.Article;
import ru.beregmira.SMSpring.service.ArticleService;
import ru.beregmira.SMSpring.service.UserAppService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class EditorController {
    @Autowired
    private ArticleService articleService;

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
        articleService.save(article);
        return "redirect:../main";
    }

    @RequestMapping(value = "/editor/edit", method = RequestMethod.POST)
    public String editArticle(@ModelAttribute Article EditArticle) {
        articleService.save(EditArticle);
        return "redirect:../main";
    }

    @RequestMapping(value = "/edit", params = {"id"}, method = GET)
    public String getEditSingleArticle(Model model,
                                       @RequestParam(value = "id") Long id) {
        model.addAttribute("EditArticle", articleService.getSingleArticle(id));
        return "edit";
    }

    @RequestMapping(value = "/editor/delete", params = {"id"}, method = GET)
    public String getDeleteSingleArticle(@ModelAttribute Article article) {
        articleService.deleteArticleById(article.getId());
        return "redirect:../main";
    }
}
