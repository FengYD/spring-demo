package com.feng.demo.itext7.start.c04;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;


/**
 * @author fengyadong
 * @date 2023/4/24 16:30
 * @Description 添加文本注释
 */
@Slf4j
public class C04E01_01_TextAnnotation {

    public static final String DEST = "spring-demo-itext7/results/chapter04/1.text_annotation.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C04E01_01_TextAnnotation().createPdf(DEST);
        log.info("success generate pdf 1.text_annotation.pdf");
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        //Initialize document
        Document document = new Document(pdf);
        document.add(new Paragraph("The example of text annotation."));

        //Create text annotation
        PdfAnnotation ann = new PdfTextAnnotation(new Rectangle(20, 800, 0, 0))
                .setOpen(false)
                .setColor(ColorConstants.GREEN)
                .setTitle(new PdfString("iText"))
                .setContents("With iText, you can truly take your documentation needs to the next level.");
        pdf.getFirstPage().addAnnotation(ann);

        //Close document
        document.close();

    }

}
