package com.romans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class RomansApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(RomansApplication.class, args);
    }

}
