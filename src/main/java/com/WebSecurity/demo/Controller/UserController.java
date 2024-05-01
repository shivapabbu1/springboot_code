package com.WebSecurity.demo.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

	@GetMapping("/welcome")
	public String welcome() {
		return ("<h1>Welcome to App </h1>");
	}

	@GetMapping("/admin")
	public String admin() {
		return ("<h1> 'Hello, ADMN!'</h1>");
	}

	@GetMapping("/user")
	public String user() {
		return ("<h1> 'Hello, user!'</h1>");
	}

}
