package com.feng.demo.itext7.start.c04;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfLineAnnotation;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author fengyadong
 * @date 2023/4/24 16:47
 * @Description
 */
@Slf4j
public class C04E01_03_LineAnnotation {

    public static final String DEST = "spring-demo-itext7/results/chapter04/3.line_annotation.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C04E01_03_LineAnnotation().createPdf(DEST);
        log.info("success generate pdf 3.line_annotation.pdf");
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PdfPage page = pdf.addNewPage();

        PdfArray lineEndings = new PdfArray();
        lineEndings.add(PdfName.Diamond);
        lineEndings.add(PdfName.Diamond);

        //Create line annotation with inside caption
        PdfAnnotation annotation = new PdfLineAnnotation(
                new Rectangle(0, 0),
                new float[]{20, 790, page.getPageSize().getWidth() - 20, 790})
                .setLineEndingStyles((lineEndings))
                .setContentsAsCaption(true)
                .setTitle(new PdfString("iText"))
                .setContents("The example of line annotation")
                .setColor(ColorConstants.BLUE);
        page.addAnnotation(annotation);

        //Close document
        pdf.close();

    }
}

