package com.feng.demo.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author fengyadong
 * @date 2022/4/2 4:45 下午
 * @Description
 */
@Data
public class AccessFileVo {

    private String originName;

    private String bucket;

    private String path;

    private Date uploadTime;

    private Date lastAssessTime;
}
