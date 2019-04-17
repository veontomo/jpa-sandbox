package com.veontomo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LsApp3 implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ItemRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(LsApp3.class, args);
    }

    public void run(String... args) throws Exception {
        repository.findAll().stream().forEach(i -> logger.info(i.toString()));
        repository.save(new Item("item 3"));
        repository.save(new Item("item 4"));
        repository.findAll().stream().forEach(i -> logger.info(i.toString()));
    }

}
