package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 使用@SpringBootApplication表示这是一个springboot应用
 * 使用@EnableCaching开启缓存功能
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {
        /**
         * 启动springboot应用
         */
        SpringApplication.run(DemoApplication.class, args);
    }

}
