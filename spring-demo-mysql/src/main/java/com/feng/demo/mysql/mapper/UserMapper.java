package com.feng.demo.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.demo.model.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fengyadong001
 * @date 2022/3/24 10:25 上午
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
