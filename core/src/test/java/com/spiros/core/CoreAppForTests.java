package com.spiros.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.spiros.persistance.entity")
@ComponentScan({"com.spiros"})
public class CoreAppForTests {

    public static void main(String[] args) {
        SpringApplication.run(CoreAppForTests.class, args);
    }

}
