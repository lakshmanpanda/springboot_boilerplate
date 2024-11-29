package com.sample.springboot_boilerplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins for development or specify only trusted origins for production
        registry.addMapping("/**") // This will allow CORS for all your endpoints
                .allowedOrigins("http://localhost:5173") // Add the frontend origin (adjust the port as needed)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
                .allowedHeaders("*") // Allow all headers (you can be more specific if needed)
                .allowCredentials(true); // Allow credentials (cookies, authorization headers, etc.)
    }
}