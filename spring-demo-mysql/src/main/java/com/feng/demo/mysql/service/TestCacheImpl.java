package com.feng.demo.mysql.service;

import com.feng.demo.model.domain.Area;
import com.feng.demo.mysql.mapper.AreaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fengyadong
 * @date 2022/8/24 14:59
 * @Description
 */
@Service
public class TestCacheImpl implements TestCache{

    @Resource
    private AreaMapper areaMapper;

    @Override
    public void test() {
        Long pid = 2L;
        List<Area> areaList = areaMapper.selectByPid(pid);
        System.out.println(areaList.size());
        areaList.removeIf(e -> e.getId().equals(3L));
        List<Area> anotherAreaList = areaMapper.selectByPid(pid);
        System.out.println(anotherAreaList.size());
    }

    @Override
    public void test2() {
        Long pid = 2L;
        List<Area> areaList = areaMapper.selectByPid(pid);
        System.out.println(areaList.size());
        List<Area> removeAreaList = new ArrayList<>();
        areaList.forEach(e -> {
            if (Arrays.asList(3L,4L,5L).contains(e.getId())) {
                removeAreaList.add(e);
            }
        });
        areaList.removeAll(removeAreaList);
        List<Area> anotherAreaList = areaMapper.selectByPid(pid);
        System.out.println(anotherAreaList.size());
    }
}
