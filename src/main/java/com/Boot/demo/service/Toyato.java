package com.Boot.demo.service;

import org.springframework.stereotype.Component;

@Component
public class Toyato implements Car {
	
	@Override
	public String getCar() {
		return "Toyato car Manfactured";
	}

}
