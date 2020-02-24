package com.microcold.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.microcold.demo.dao")
public class DemoApplication
{

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}