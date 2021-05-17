package com.nitish.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nitish.springboot.cruddemo.rest.EmployeeRestController;

@SpringBootApplication
//@ComponentScan(basePackageClasses=EmployeeRestController.class)

public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
