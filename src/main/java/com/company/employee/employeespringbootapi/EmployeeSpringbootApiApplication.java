package com.company.employee.employeespringbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class EmployeeSpringbootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSpringbootApiApplication.class, args);
    }

}
