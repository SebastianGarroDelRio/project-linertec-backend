package com.centroinformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.centroinformacion.controller")
public class ProjectLinertecBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLinertecBackendApplication.class, args);
	}

}
