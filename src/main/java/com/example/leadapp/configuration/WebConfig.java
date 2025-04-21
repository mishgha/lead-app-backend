package com.example.leadapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to customize Spring MVC settings.
 * This class specifically defines a CORS (Cross-Origin Resource Sharing) configuration bean
 * to allow requests from the frontend application running on localhost.
 */
@Configuration
public class WebConfig {

    /**
     * Configures CORS settings for the application.
     *
     * @return a {@link WebMvcConfigurer} instance with CORS mappings allowing requests from
     *         "http://localhost:3000" for all endpoints and standard HTTP methods.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * Adds CORS mappings to allow cross-origin requests from the frontend.
             *
             * @param registry the {@link CorsRegistry} to which mappings are added.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }
}
