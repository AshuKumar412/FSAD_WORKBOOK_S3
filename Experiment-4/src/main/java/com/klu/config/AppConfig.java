package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.model.Student;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {

        return new Student(0, "Default", "None", 0);
    }
}