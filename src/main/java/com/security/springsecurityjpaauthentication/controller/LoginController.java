package com.security.springsecurityjpaauthentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/teste")
    public String teste(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        return "teste";
    }

    @GetMapping("/teste2")
    public String teste2(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        return "teste2";
    }

    @GetMapping("/index")
    public String index(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/exit")
    public String logout() {
        return "exit";
    }
}
