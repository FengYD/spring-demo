package com.feng.demo.mysql.domain;

import com.feng.demo.model.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengyadong001
 * @date 2022/3/23 5:51 下午
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseDomain {

    private String userName;

    private String realName;

    private String phone;

    private Integer age;
}