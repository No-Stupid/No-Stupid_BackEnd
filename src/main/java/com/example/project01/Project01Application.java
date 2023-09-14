package com.example.project01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Project01Application {

    public static void main(String[] args) {
        SpringApplication.run(Project01Application.class, args);
    }

}
