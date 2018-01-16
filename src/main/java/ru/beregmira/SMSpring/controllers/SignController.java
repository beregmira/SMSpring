package ru.beregmira.SMSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.beregmira.SMSpring.model.UserApp;

@Controller
public class SignController {
    @RequestMapping(value = "/sign")
    public String signPage(Model model) {
        model.addAttribute("user", new UserApp());
        return "sign";
    }
}
