package com.OOP.CW.Backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home")
public class SystemController {

    @GetMapping
    public String greeting() {
        return "Hello World";
    }
}
