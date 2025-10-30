package com.OPA.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/libros")
    public String libros() {
        return "redirect:/dashboard#libros";
    }

    @GetMapping("/autores")
    public String autores() {
        return "redirect:/dashboard#autores";
    }
}
