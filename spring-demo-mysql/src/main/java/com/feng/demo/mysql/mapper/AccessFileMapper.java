package com.feng.demo.mysql.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.demo.model.domain.AccessFile;
import com.feng.demo.model.enums.YesNoEnum;

/**
 * @author fengyadong
 * @date 2022/4/2 4:55 下午
 * @Description
 */
public interface AccessFileMapper extends BaseMapper<AccessFile> {

    default AccessFile selectOneByPath(String path) {
        LambdaQueryWrapper<AccessFile> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AccessFile::getPath, path)
                .eq(AccessFile::getIsDelete, YesNoEnum.NO.getCode());
        return selectOne(wrapper);
    }

}
