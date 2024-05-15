package com.mybom.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
	
	@GetMapping("/bom")
	public String bomdemo() {
		return ("hello bomdemo project");
	}

}
