package com.example.leadapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Lead Application.
 * This class contains the main method which starts the Spring Boot application.
 * It is annotated with {@link SpringBootApplication} to enable auto-configuration, component scanning, and configuration properties.
 */
@SpringBootApplication
public class LeadAppApplication {

    /**
     * The main method which serves as the entry point for the Spring Boot application.
     * It runs the Spring application context and launches the application.
     *
     * @param args the command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(LeadAppApplication.class, args);
    }

}
