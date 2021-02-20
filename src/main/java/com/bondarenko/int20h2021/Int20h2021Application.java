package com.bondarenko.int20h2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Int20h2021Application {

    public static void main(String[] args) {
        SpringApplication.run(Int20h2021Application.class, args);
    }

}
