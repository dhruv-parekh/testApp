package com.example.testApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TestAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestAppApplication.class, args);
		System.out.println("hello world");
	}


}
