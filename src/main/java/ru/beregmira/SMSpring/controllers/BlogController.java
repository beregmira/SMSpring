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
import ru.beregmira.SMSpring.model.Comment;
import ru.beregmira.SMSpring.model.UserApp;
import ru.beregmira.SMSpring.service.ArticleService;
import ru.beregmira.SMSpring.service.CommentsService;
import ru.beregmira.SMSpring.service.UserAppService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserAppService userAppService;

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/blog", params = {"id"}, method = GET)
    public String getSingleArticle(Model model, @AuthenticationPrincipal UserDetails currentUser,
                                   @RequestParam(value = "id") Long id) {
        UserApp userApp = userAppService.getUserAppByName(currentUser.getUsername());
        model.addAttribute("SingleArticle", articleService.getSingleArticle(id));
        model.addAttribute("ListOfAllComments", commentsService.getAllCommentsByArticleId(id));
        model.addAttribute("NewComment", new Comment());
        model.addAttribute("CurrentUserAppId", userAppService.getUserAppIdByCurrentUserName(currentUser));
        model.addAttribute("geInfoCommetns", userAppService);
        model.addAttribute("currentUser", userApp);
        return "SingleArticle";
    }

    @RequestMapping(value = "/blog/comment", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Comment NewComment) {
        commentsService.save(NewComment);
        return "redirect:../main";
    }


    @RequestMapping(value = "/blog/comment/delete", params = {"id"}, method = GET)
    public String getDeleteSingleComments(@ModelAttribute Comment comment) {
        commentsService.deleteCommentById(comment.getId());
        return "redirect:/main";
    }
}
