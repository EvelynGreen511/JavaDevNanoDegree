package edu.udacity.java.nano.controller;

import edu.udacity.java.nano.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(User user) {
        return "/login";
    }

    @RequestMapping(value = "/chat")
    public String loginChat(@Valid User user, BindingResult result, Model model) {

        if(result.hasErrors()) {
            System.out.println("Validation Error username");
            return "/login";
        }

        model.addAttribute("username", user.getUsername());
        return "/chat";
    }
}
