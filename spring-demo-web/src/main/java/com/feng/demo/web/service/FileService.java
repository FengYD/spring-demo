package com.feng.demo.web.service;

import com.feng.demo.model.vo.AccessFileVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @author fengyadong
 * @date 2022/4/2 4:43 下午
 * @Description
 */
public interface FileService {

    /**
     * 批量上传文件
     *
     * @param fileList 文件列表
     * @return 上传文件的信息
     */
    List<AccessFileVo> upload(List<MultipartFile> fileList);

    /**
     * 上传文件
     *
     * @param file 文件
     * @return 上传文件的信息
     */
    AccessFileVo upload(MultipartFile file);

    /**
     * 下载文件
     *
     * @param path 文件路径
     * @return 流
     */
    InputStream download(String path);

    /**
     * 检查文件
     *
     * @param path 文件路径
     * @return 文件信息
     */
    AccessFileVo access(String path);

    /**
     * 删除文件
     *
     * @param path 文件路径
     */
    void delete(String path);

}
