package com.makemyown.CustomCloth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CustomClothApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomClothApplication.class, args);
		System.out.println("running successfully");
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:3000") // React frontend URL
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
