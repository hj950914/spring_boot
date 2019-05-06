package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用@SpringBootApplication表示这是一个springboot应用
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        /**
         * 启动springboot应用
         */
        SpringApplication.run(DemoApplication.class, args);
    }

}
