package com.feng.demo.mysql.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.feng.demo.model.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengyadong001
 * @date 2022/3/23 5:51 下午
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("test_user")
public class User extends BaseDomain {

    @TableId
    private Long id;

    private String userName;

    private String realName;

    private String phone;

    private Integer age;
}