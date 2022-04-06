package com.feng.demo.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author fengyadong
 * @date 2022/4/2 4:24 下午
 * @Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("area")
public class Area extends BaseDomain {
    @TableId
    private Long id;

    private Long pid;

    private String shortName;

    private String name;

    private Integer level;

    private String pinYin;

    private String code;

    private String zipCode;

    private String first;

    private String lng;

    private String lat;
}
