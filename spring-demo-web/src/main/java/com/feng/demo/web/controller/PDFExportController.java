package com.feng.demo.web.controller;


import com.feng.demo.model.constant.HttpContentType;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author fengyadong
 * @date 2022/4/2 9:13 上午
 * @Description 生成 pdf 文档
 */
@Slf4j
@RestController
@RequestMapping("/pdf")
public class PDFExportController {

    /**
     * pdf 版 hello world
     */
    @RequestMapping("/export/hello")
    public void exportHello(HttpServletResponse response) {
        try (OutputStream out = new BufferedOutputStream(response.getOutputStream());
             PdfWriter writer = new PdfWriter(out);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)
        ) {
            response.setContentType(HttpContentType.BIN);
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("hello.pdf", "UTF-8"));
            document.add(new Paragraph("Hello World!"));
        } catch (IOException e) {
            log.error("生成 pdf 失败");
        }
    }

    @RequestMapping("/export/list")
    public void exportList(HttpServletResponse response) {
        try (OutputStream out = new BufferedOutputStream(response.getOutputStream());
             PdfWriter writer = new PdfWriter(out);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)
        ) {
            response.setContentType(HttpContentType.BIN);
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("list.pdf", "UTF-8"));
            PdfFont font = PdfFontFactory.createFont();
            document.add(new Paragraph("iText is:").setFont(font));
            List list = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            list.add(new ListItem("Never gonna give you up"))
                    .add(new ListItem("Never gonna let you down"))
                    .add(new ListItem("Never gonna run around and desert you"))
                    .add(new ListItem("Never gonna make you cry"))
                    .add(new ListItem("Never gonna say goodbye"))
                    .add(new ListItem("Never gonna tell a lie and hurt you"));
            document.add(list);
        } catch (IOException e) {
            log.error("生成 pdf 失败");
        }
    }


}
