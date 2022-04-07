package com.feng.demo.utils.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.word.Word07Writer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.*;

/**
 * @author fengyadong
 * @date 2022/4/7 1:49 下午
 * @Description
 */
@Slf4j
@Service
public class WordGenerateService {

    public void simpleWord(String dest) {
        Word07Writer writer = new Word07Writer();
        // 添加段落（标题）
        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
        // 添加段落（正文）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
        // 写出到文件
        writer.flush(FileUtil.file(dest));
        // 关闭
        writer.close();
    }

    public void simpleTable(String dest) {
    }
}
