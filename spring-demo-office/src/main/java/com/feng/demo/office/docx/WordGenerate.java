package com.feng.demo.office.docx;

import com.deepoove.poi.XWPFTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengyadong
 * @date 2022/4/12 10:51 上午
 * @Description
 */
public class WordGenerate {


    public static void main(String[] args) throws Exception {
        //freemarker();
        poiTL3();
    }

    public static void freemarker() throws Exception {
        /** 初始化配置文件 **/
        Configuration configuration = new Configuration(new Version("2.3.31"));
        /** 设置编码 **/
        configuration.setDefaultEncoding("utf-8");
        String fileDirectory = "spring-demo-office/src/main/resources/templates";
        /** 加载文件 **/
        configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
        /** 加载模板 **/
        Template template = configuration.getTemplate("freexml.ftl");
        /** 准备数据 **/
        Map<String, String> dataMap = new HashMap<>();
        /** 在ftl文件中有${textDeal}这个标签**/
        dataMap.put("aaa", "测试1");
        dataMap.put("bbb", "测试1");
        /** 指定输出word文件的路径 **/
        String outFilePath = "/Users/fengyadong/Desktop/freemarker.doc";
        File docFile = new File(outFilePath);
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
        Map<String, String> dataMap1 = new HashMap<>();
        if (out != null) {
            out.close();
        }
    }

    public static void poiTL() throws Exception {
        XWPFTemplate template = XWPFTemplate.compile("spring-demo-word/src/main/resources/templates/poitl.docx").render(
                new HashMap<String, Object>() {{
                    put("a", "Hi, poi-tl Word模板引擎");
                }});
        template.writeAndClose(new FileOutputStream("/Users/fengyadong/Desktop/poitl.docx"));

        XWPFTemplate template2 = XWPFTemplate.compile("spring-demo-word/src/main/resources/templates/poitl2.docx").render(
                new HashMap<String, Object>() {{
                    put("c", "5");
                }});
        template2.writeAndClose(new FileOutputStream("/Users/fengyadong/Desktop/poitl2.docx"));
    }


    public static void poiTL2() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("/Users/fengyadong/Desktop/poitl3.docx");
        XWPFTemplate template = XWPFTemplate.compile("spring-demo-word/src/main/resources/templates/poitl.docx").render(
                new HashMap<String, Object>() {{
                    put("a", "Hi, poi-tl Word模板引擎");
                }});
        template.write(outputStream);
        template.writeAndClose(template.getXWPFDocument().getXWPFDocument().getPackagePart().getOutputStream());
    }

    public static void poiTL3() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("/Users/fengyadong/Desktop/poitl4.docx");
        Map<String, String> son1 = new HashMap<>();
        son1.put("a", "a1");
        son1.put("b", "b1");
        Map<String, String> son2 = new HashMap<>();
        son2.put("a", "a2");
        son2.put("b", "b2");
        List<Map<String, String>> list = new ArrayList<>();
        list.add(son1);
        list.add(son2);
        Map<String, Object> f = new HashMap<>();
        f.put("list", list);
        XWPFTemplate template = XWPFTemplate.compile("spring-demo-word/src/main/resources/templates/poitl3.docx").render(f);
        template.write(outputStream);
        template.writeAndClose(template.getXWPFDocument().getXWPFDocument().getPackagePart().getOutputStream());
    }

}
