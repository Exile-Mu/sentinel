package com.exile.sentineldemo;

import com.exile.sentineldemo.service.FileDataSourceDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentineldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentineldemoApplication.class, args);
        FileDataSourceDemo.initFileDataSourceRules();
    }

}
