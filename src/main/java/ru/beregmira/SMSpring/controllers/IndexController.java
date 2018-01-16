package ru.beregmira.SMSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {

    @RequestMapping(value={"/", "/welcome"})
    public String mainPage() {
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logoutPage() {
        return "index";
    }


}
