package com.feng.demo.itext7.start.c03;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author fengyadong
 * @date 2023/4/23 15:16
 * @Description 内容分块
 */
@Slf4j
public class C03E01_NewYorkTimes {


    public static final String DEST = "spring-demo-itext7/results/chapter03/1.new_york_times.pdf";

    public static final String APPLE_IMG = "spring-demo-itext7/src/main/resources/img/ny_times_apple.jpg";
    public static final String APPLE_TXT = "spring-demo-itext7/src/main/resources/data/ny_times_apple.txt";
    public static final String FACEBOOK_IMG = "spring-demo-itext7/src/main/resources/img/ny_times_fb.jpg";
    public static final String FACEBOOK_TXT = "spring-demo-itext7/src/main/resources/data/ny_times_fb.txt";
    public static final String INST_IMG = "spring-demo-itext7/src/main/resources/img/ny_times_inst.jpg";
    public static final String INST_TXT = "spring-demo-itext7/src/main/resources/data/ny_times_inst.txt";

    static PdfFont timesNewRoman = null;
    static PdfFont timesNewRomanBold = null;

    public static void main(String[] args) throws Exception {
        timesNewRoman = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        timesNewRomanBold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C03E01_NewYorkTimes().createPdf(DEST);
        log.info("success generate pdf 1.new_york_times.pdf");
    }

    protected void createPdf(String dest) throws Exception {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        // 420.0F * 595.0F
        PageSize ps = PageSize.A5;

        // Initialize document
        Document document = new Document(pdf, ps);

        //Set column parameters
        float offSet = 36;
        // 分成3栏 边距36 每栏间距5 每栏116
        float columnWidth = (ps.getWidth() - offSet * 2 + 5 * 2) / 3;
        float columnHeight = ps.getHeight() - offSet * 2;

        //Define column areas
        Rectangle[] columns = {new Rectangle(offSet - 5, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth * 2 + 5, offSet, columnWidth, columnHeight)};
        document.setRenderer(new ColumnDocumentRenderer(document, columns));

        Image apple = new Image(ImageDataFactory.create(APPLE_IMG)).setWidth(columnWidth);
        String articleApple = new String(Files.readAllBytes(Paths.get(APPLE_TXT)), StandardCharsets.UTF_8);
        String titleApple = "Apple Encryption Engineers, if Ordered to Unlock iPhone, Might Resist";
        String authorApple = "By JOHN MARKOFF MARCH 18, 2016";
        C03E01_NewYorkTimes.addArticle(document, titleApple, authorApple, apple, articleApple);


        Image facebook = new Image(ImageDataFactory.create(FACEBOOK_IMG)).setWidth(columnWidth);
        String articleFB = new String(Files.readAllBytes(Paths.get(FACEBOOK_TXT)), StandardCharsets.UTF_8);
        String titleFB = "With \"Smog Jog\" Through Beijing, Zuckerberg Stirs Debate on Air Pollution";
        String authorFB = "By PAUL MOZUR MARCH 18, 2016";
        C03E01_NewYorkTimes.addArticle(document, titleFB, authorFB, facebook, articleFB);


        Image inst = new Image(ImageDataFactory.create(INST_IMG)).setWidth(columnWidth);
        String articleInstagram = new String(Files.readAllBytes(Paths.get(INST_TXT)), StandardCharsets.UTF_8);
        String titleInstagram = "Instagram May Change Your Feed, Personalizing It With an Algorithm";
        String authorInstagram = "By MIKE ISAAC MARCH 15, 2016";
        C03E01_NewYorkTimes.addArticle(document, titleInstagram, authorInstagram, inst, articleInstagram);

        document.close();
    }

    public static void addArticle(Document doc, String title, String author, Image img, String text) {
        Paragraph pTitle = new Paragraph(title)
                .setFont(timesNewRomanBold)
                .setFontSize(14);
        doc.add(pTitle);
        doc.add(img);
        Color grayColor = new DeviceCmyk(0.f, 0.f, 0.f, 0.875f);
        Paragraph pAuthor = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(7)
                .setFontColor(grayColor)
                .add(author);
        doc.add(pAuthor);
        Paragraph pText = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(10)
                .add(text);
        doc.add(pText);
    }

}
