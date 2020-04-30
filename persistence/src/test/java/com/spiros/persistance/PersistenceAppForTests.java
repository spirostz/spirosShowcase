package com.spiros.persistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.spiros.persistance.entity")
@ComponentScan({"com.spiros"})
public class PersistenceAppForTests {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceAppForTests.class, args);
    }

}
