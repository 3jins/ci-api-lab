package com.sejin.ciapilab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CiApiLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CiApiLabApplication.class, args);
    }

}
