package com.feng.demo.mysql.domain;

import com.feng.demo.model.domain.BaseDomain;
import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * @author fengyadong001
 * @date 2022/3/23 5:51 下午
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseDomain {

    private String userName;

    private String realName;

    private String phone;

    private Integer age;
}