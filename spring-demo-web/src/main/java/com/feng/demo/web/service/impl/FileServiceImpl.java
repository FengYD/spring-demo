package com.feng.demo.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.feng.demo.minio.config.MinIOTemplate;
import com.feng.demo.model.domain.AccessFile;
import com.feng.demo.model.enums.YesNoEnum;
import com.feng.demo.model.vo.AccessFileVo;
import com.feng.demo.mysql.mapper.AccessFileMapper;
import com.feng.demo.web.service.FileService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fengyadong
 * @date 2022/4/2 4:48 下午
 * @Description
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinIOTemplate minIOTemplate;

    @Resource
    private AccessFileMapper accessFileMapper;

    @SneakyThrows
    public List<AccessFileVo> upload(List<MultipartFile> fileList) {
        List<AccessFileVo> resultList = new ArrayList<>(fileList.size());
        for (MultipartFile file : fileList) {
            AccessFileVo vo = upload(file);
            resultList.add(vo);
        }
        return resultList;
    }

    @SneakyThrows
    public AccessFileVo upload(MultipartFile file) {
        String path = minIOTemplate.upload(file.getOriginalFilename(), file.getInputStream());
        AccessFile accessFile = new AccessFile();
        accessFile.setOriginName(file.getName());
        accessFile.setUploadTime(new Date());
        accessFile.setLastAssessTime(new Date());
        accessFile.setPath(path);
        accessFileMapper.insert(accessFile);
        AccessFileVo vo = JSON.parseObject(JSON.toJSONString(accessFile), AccessFileVo.class);
        return vo;
    }

    public InputStream download(String path) {
        AccessFile accessFile = accessFileMapper.selectOneByPath(path);
        AccessFile update = new AccessFile();
        update.setId(accessFile.getId());
        update.setLastAssessTime(new Date());
        accessFileMapper.updateById(update);
        return minIOTemplate.downloadStream(path);
    }

    public AccessFileVo access(String path) {
        AccessFile accessFile = accessFileMapper.selectOneByPath(path);
        AccessFileVo vo = JSON.parseObject(JSON.toJSONString(accessFile), AccessFileVo.class);
        AccessFile update = new AccessFile();
        update.setId(accessFile.getId());
        update.setLastAssessTime(new Date());
        accessFileMapper.updateById(update);
        return vo;
    }

    public void delete(String path) {
        AccessFile accessFile = accessFileMapper.selectOneByPath(path);
        AccessFile update = new AccessFile();
        update.setId(accessFile.getId());
        update.setLastAssessTime(new Date());
        update.setIsDelete(YesNoEnum.YES.getCode());
        accessFileMapper.updateById(update);
        minIOTemplate.delete(path);
    }

}
