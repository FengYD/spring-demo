package com.feng.demo.office.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * @author fengyadong
 * @date 2022/4/13 5:05 下午
 * @Description
 */
public class SimplePDF {

    public static void main(String[] args) throws Exception {
        sample1();
    }


    public static void sample1() throws Exception {
        String dest = "/Users/fengyadong/Desktop/sample1.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Hello World!"));
        document.close();
    }

    public static void sample2() throws Exception {
        String dest = "/Users/fengyadong/Desktop/sample1.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Hello World!"));
        document.close();
    }
}
