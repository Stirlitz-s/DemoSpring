package com.stsoft.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringProjectApplication.class, args);
	}

}
