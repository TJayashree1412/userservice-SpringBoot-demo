package com.stackroute.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration //marks the class as spring configuration class : used to define beans
//@EnableAutoConfiguration //tells spring to start adding beans based on classpath and various property settings
//@ComponentScan //scans for spring components only in the package and its sub packages to be added to the spring application context
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
		//code here responsible for running application
}

