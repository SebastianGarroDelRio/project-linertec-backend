package com.centroinformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.centroinformacion")
public class ProjectLinertecBackendApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProjectLinertecBackendApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ProjectLinertecBackendApplication.class, args);
	}

}
