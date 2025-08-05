package com.luv2code.springoverview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
		scanBasePackages = {"com.luv2code.springoverview",
		"com.luv2code.util"}
)*/
@SpringBootApplication
public class SpringOverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOverviewApplication.class, args);
	}

}
