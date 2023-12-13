package com.centroinformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.centroinformacion.controller.EnlaceController;

@SpringBootApplication(scanBasePackageClasses = EnlaceController.class)
public class ProjectLinertecBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLinertecBackendApplication.class, args);
	}

}
