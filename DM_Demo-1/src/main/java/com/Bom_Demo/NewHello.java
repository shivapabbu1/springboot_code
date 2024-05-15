package com.Bom_Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewHello {

    @GetMapping("/new")
    public String hello() {
        return "Hello, world!";
    }
}
