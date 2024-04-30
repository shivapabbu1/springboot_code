package com.Boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Boot.demo.controller.CarController;
import com.Boot.demo.service.Car;



@SpringBootApplication
public class BootDiIocApplication {

	public static void main(String[] args) {
		
	 var context =	SpringApplication.run(BootDiIocApplication.class, args);
	 
      CarController car=context.getBean(CarController.class);  
      System.out.println(car.getCar());
      
      
        
      

		
      
    }

}
