package com.feng.demo.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @author fengyadong
 * @date 2022/4/2 4:30 下午
 * @Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("access_file")
public class AccessFile extends BaseDomain {
    @TableId
    private Long id;

    private String originName;

    private String bucket;

    private String path;

    private Date uploadTime;

    private Date lastAssessTime;

}
