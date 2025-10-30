package com.OPA.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/registrar")
    public String register() {
        return "registro";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
