package ru.skillup.youthtourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class YouthTourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouthTourismApplication.class, args);
    }

}
