package com.OOP.CW.Backend.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketsystem")
public class SystemController {

    @GetMapping
    public String Welcome() {
        return "Welcome to the Ticketing System!";
    }
}
