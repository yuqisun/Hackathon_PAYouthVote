package org.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("LOG_PATH", System.getProperty("user.dir") + File.separator);
        SpringApplication.run(Application.class, args);
    }
}