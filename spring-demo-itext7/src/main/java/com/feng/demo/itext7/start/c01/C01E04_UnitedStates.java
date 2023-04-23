package com.feng.demo.itext7.start.c01;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author fengyadong
 * @date 2023/4/23 10:58
 * @Description 根据 CSV 生成表格
 */
@Slf4j
public class C01E04_UnitedStates {
    public static final String DATA = "spring-demo-itext7/src/main/resources/data/united_states.csv";

    public static final String DEST = "spring-demo-itext7/results/chapter01/4.united_states.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C01E04_UnitedStates().createPdf(DEST);
        log.info("success generate pdf 4.united_states.pdf");
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        // 每行的相对宽度
        Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
        // 使用全部宽度
        table.useAllAvailableWidth();
        BufferedReader br = new BufferedReader(new FileReader(DATA));
        String line = br.readLine();
        // header使用粗体
        process(table, line, bold, true);
        while ((line = br.readLine()) != null) {
            process(table, line, font, false);
        }
        br.close();
        document.add(table);

        //Close document
        document.close();
    }

    public void process(Table table, String line, PdfFont font, boolean isHeader) {
        // 分割符;
//        StringTokenizer tokenizer = new StringTokenizer(line, ";");
//        while (tokenizer.hasMoreTokens()) {
//            if (isHeader) {
//                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
//            } else {
//                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
//            }
//        }
        // another way
        String[] tokens = line.split(";");
        for (String token : tokens) {
            // 段落
            Paragraph paragraph = new Paragraph(token).setFont(font);
            // 单元格
            Cell cell = new Cell().add(paragraph);
            if (isHeader) {
                table.addHeaderCell(cell);
            } else {
                table.addCell(cell);
            }
        }
    }
}