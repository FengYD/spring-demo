package com.feng.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author fengyadong001
 * @date 2022/3/8 5:57 下午
 * @description
 */
@EnableKafka
@MapperScan(basePackages = "com.feng.demo.*.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}