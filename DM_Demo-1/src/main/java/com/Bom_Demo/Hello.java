package com.Bom_Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping("/hello")
    public String get() {
    	return ("hello dm child");
    }
}
