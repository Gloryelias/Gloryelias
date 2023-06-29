package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Update with your Angular application's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add any additional HTTP methods used by your application
                .allowedHeaders("*"); // You can restrict the allowed headers if needed		
}

}
