package com.feng.demo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author fengyadong
 * @Date: 2022/3/31 22:25
 */
@Data
@Builder
public class LoginUserDTO {

    private Long userId;

    private String token;

    private String userName;

    private Date loginTime;
}
