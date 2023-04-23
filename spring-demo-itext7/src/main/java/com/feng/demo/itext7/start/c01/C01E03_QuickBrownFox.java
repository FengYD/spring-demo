package com.feng.demo.itext7.start.c01;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author fengyadong
 * @date 2023/4/23 10:26
 * @Description 图片
 */
@Slf4j
public class C01E03_QuickBrownFox {

    // 图片地址
    public static final String DOG = "spring-demo-itext7/src/main/resources/img/dog.bmp";
    public static final String FOX = "spring-demo-itext7/src/main/resources/img/fox.bmp";

    public static final String DEST = "spring-demo-itext7/results/chapter01/3.quick_brown_fox.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C01E03_QuickBrownFox().createPdf(DEST);
        log.info("success generate pdf 3.quick_brown_fox.pdf");
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        // Compose Paragraph
        // image itext7内置对象
        Image fox = new Image(ImageDataFactory.create(FOX));
        Image dog = new Image(ImageDataFactory.create(DOG));
        Paragraph p = new Paragraph("The quick brown ")
                .add(fox)
                .add(" jumps over the lazy ")
                .add(dog);
        // Add Paragraph to document
        document.add(p);

        //Close document
        document.close();

    }

}
