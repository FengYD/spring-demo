package com.feng.demo.mysql.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.demo.model.domain.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fengyadong
 * @date 2022/4/3 3:54 下午
 * @Description
 */
@Mapper
public interface AreaMapper extends BaseMapper<Area> {

    default List<Area> selectByPid(Long pid) {
        LambdaQueryWrapper<Area> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Area::getPid, pid);
        return this.selectList(wrapper);
    }

}
