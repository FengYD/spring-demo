package com.feng.demo.h2.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

/**
 * @author fengyadong001
 * @date 2022/3/11 5:50 下午
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class User {

    @Id
    private Long id;

    private String name;

    private int age;
}