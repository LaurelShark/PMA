package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String greeting() {
        return "index.html";
    }
}
