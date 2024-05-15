package com.example.demo_parent;

import wniemiec.util.java.StringUtils;

public class PService {
	
	public String greetUser(String name) {
        return "Hello, " + StringUtils.capitalize(name) + "!";
    }

}
