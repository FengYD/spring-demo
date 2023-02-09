package com.feng.demo.mysql.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.demo.model.domain.AccessFile;
import com.feng.demo.model.enums.YesNoEnum;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fengyadong
 * @date 2022/4/2 4:55 下午
 * @Description
 */
@Mapper
public interface AccessFileMapper extends BaseMapper<AccessFile> {

    default AccessFile selectOneByPath(String path) {
        LambdaQueryWrapper<AccessFile> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AccessFile::getPath, path)
                .eq(AccessFile::getIsDelete, YesNoEnum.NO.getCode());
        return selectOne(wrapper);
    }

}
