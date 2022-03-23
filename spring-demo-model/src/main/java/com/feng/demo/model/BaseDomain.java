package com.feng.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author fengyadong001
 * @date 2022/3/23 5:48 下午
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDomain {

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;
}