package com.example.employeemanagementapi.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configure Cross-Origin Resource Sharing (CORS) for the Spring application.
     *
     * @param registry The CorsRegistry used to register CORS configuration.
     *                 Allows specifying how CORS should be handled for different endpoints.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply this CORS configuration to all endpoints
                .allowedOrigins("http://localhost:3000") // Allow requests from this origin (your React frontend)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                .allowCredentials(true); // Allow credentials (e.g., cookies) to be sent with the requests
    }

}
