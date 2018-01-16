package ru.beregmira.SMSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.beregmira.SMSpring.model.UserApp;
import ru.beregmira.SMSpring.service.UserAppService;

@Controller
@RequestMapping(value={"/", "/welcome"})
public class LoginController {
    @Autowired
    private UserAppService userAppService;

    @RequestMapping(value = "/login/registration", method = RequestMethod.POST)
    public String submitUser(@ModelAttribute UserApp user) {
        userAppService.save(user);
        return "redirect:../";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
