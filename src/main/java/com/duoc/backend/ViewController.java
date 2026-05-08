package com.duoc.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/pets-view")
    public String pets() {
        return "pets";
    }

    @GetMapping("/adoption-view")
    public String adoption() {
        return "adoption";
    }
}