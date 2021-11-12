package com.br.uniamerica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ContactoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactoApplication.class, args);
    }

}
