package com.feng.demo.web.controller;

import com.feng.demo.model.constant.HttpContentType;
import com.feng.demo.model.vo.AccessFileVo;
import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.web.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author fengyadong
 * @date 2022/4/2 4:19 下午
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileAccessController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/upload")
    public BaseVo upload(List<MultipartFile> fileList) {
        List<AccessFileVo> list = fileService.upload(fileList);
        return BaseVo.success(list);
    }

    @RequestMapping("/download")
    public void download(String path, HttpServletResponse response) {
        AccessFileVo vo = fileService.access(path);
        response.setContentType(HttpContentType.BIN);
        try (InputStream in = fileService.download(path);
             OutputStream out = new BufferedOutputStream(response.getOutputStream())
        ) {
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(vo.getOriginName(), "UTF-8"));
            if (in != null) {
                byte[] buff = new byte[512000];
                for (int byteRead = 0; (byteRead = in.read(buff)) != -1; ) {
                    out.write(buff, 0, byteRead);
                    out.flush();
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public void delete(String path) {
        fileService.delete(path);
    }

}
