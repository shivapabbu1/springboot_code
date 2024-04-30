package com.Boot.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Honda implements Car {
	
	@Override
	public String getCar() {
		
	return "New Honda car arrived.";
	}

	
}
