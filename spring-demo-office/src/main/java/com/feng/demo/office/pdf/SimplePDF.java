package com.feng.demo.office.pdf;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

/**
 * @author fengyadong
 * @date 2022/4/13 5:05 下午
 * @Description
 */
public class SimplePDF {

    public static void main(String[] args) throws Exception {
        sample2();
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
        String dest = "/Users/fengyadong/Desktop/sample2.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        // Create a PdfFont
        PdfFont font = PdfFontFactory.createFont();
        // Add a Paragraph
        document.add(new Paragraph("iText is:").setFont(font));
        // Create a List
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
        // Add ListItem objects
        list.add(new ListItem("Never gonna give you up"))
                .add(new ListItem("Never gonna let you down"))
                .add(new ListItem("Never gonna run around and desert you"))
                .add(new ListItem("Never gonna make you cry"))
                .add(new ListItem("Never gonna say goodbye"))
                .add(new ListItem("Never gonna tell a lie and hurt you"));
        // Add the list
        document.add(list);
        document.close();
    }
}
