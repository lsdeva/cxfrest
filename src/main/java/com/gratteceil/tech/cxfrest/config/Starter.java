package com.gratteceil.tech.cxfrest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.gratteceil.tech")
@EntityScan(basePackages = "com.gratteceil.tech.cxfrest.modle")
@EnableJpaRepositories(basePackages = "com.gratteceil.tech.cxfrest.repo")
public class Starter {

    public static void main(final String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
