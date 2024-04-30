package com.Boot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.Boot.demo.service.Car;
import com.Boot.demo.service.Honda;

import com.Boot.demo.service.Toyato;

@Component
public class CarController {
	
	
//	@Autowired
  
	private Honda honda;
		
//	//-->Constructor Injection
	
	
	public CarController(Honda honda) {
		this.honda=honda;
	}
	
	public String getCar() {
		 return honda.getCar() ;
    }
	
	
	//-->Setter Injection
//	@Autowired
//	public void setHondaCar(Honda honda) {
//		this.honda=honda;
//	}
	
	
	
	
//Interface DI 
	
//	
//	private Car car;
//	
//	@Autowired
//	public CarController(@Qualifier("honda") Car car) {
//		this.car=car;
//	}

//
//	public String getCar() {
//		 return car.getCar() ;
//	}
	
 
}
