package com.feng.demo.itext7.start.c03;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * @author fengyadong
 * @date 2023/4/23 16:00
 * @Description
 */
@Slf4j
public class C03E03_UFO {

    public static final String DATA = "spring-demo-itext7/src/main/resources/data/ufo.csv";
    public static final String DEST = "spring-demo-itext7/results/chapter03/3.ufo.pdf";

    static PdfFont helvetica = null;
    static PdfFont helveticaBold = null;

    public static void main(String[] args) throws Exception {
        helvetica = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        helveticaBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C03E03_UFO().createPdf(DEST);
        log.info("success generate pdf 3.ufo.pdf");
    }

    protected void createPdf(String dest) throws Exception {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        // END_PAGE
        // That is: every time iText has finished adding content to a page,
        // either because a new page is created, or because the last page has been reached and completed
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());

        // Initialize document
        Document document = new Document(pdf);

        Paragraph p = new Paragraph("List of reported UFO sightings in 20th century")
                .setTextAlignment(TextAlignment.CENTER).setFont(helveticaBold).setFontSize(14);
        document.add(p);

        Table table = new Table(UnitValue.createPercentArray(new float[]{3, 5, 7, 4}));

        BufferedReader br = new BufferedReader(new FileReader(DATA));
        String line = br.readLine();
        process(table, line, helveticaBold, true);
        while ((line = br.readLine()) != null) {
            process(table, line, helvetica, false);
        }
        br.close();

        document.add(table);

        document.close();
    }

    public void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            if (isHeader) {
                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)).setFontSize(9).setBorder(new SolidBorder(ColorConstants.BLACK, 0.5f)));
            } else {
                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)).setFontSize(9).setBorder(new SolidBorder(ColorConstants.BLACK, 0.5f)));
            }
        }
    }


    protected static class MyEventHandler implements IEventHandler {

        public void handleEvent(Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdfDoc = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            int pageNumber = pdfDoc.getPageNumber(page);
            Rectangle pageSize = page.getPageSize();
            // newContentStreamBefore 在当前流之前写入流，设置背景色不至于覆盖文字
            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);

            // Disappear不会会出现 背景色把它覆盖了
            Canvas myCanvas = new Canvas(pdfCanvas, page.getPageSize());
            myCanvas.setFontColor(ColorConstants.WHITE);
            myCanvas.setProperty(Property.FONT_SIZE, UnitValue.createPointValue(60));
            myCanvas.setProperty(Property.FONT, helveticaBold);
            myCanvas.showTextAligned(new Paragraph("Disappear"), 100, 400, pdfDoc.getPageNumber(page),
                    TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);
            // Disappear不会会出现 背景色把它覆盖了

            //Set background
            Color limeColor = new DeviceCmyk(0.208f, 0, 0.584f, 0);
            Color blueColor = new DeviceCmyk(0.445f, 0.0546f, 0, 0.0667f);
            pdfCanvas.saveState()
                    .setFillColor(pageNumber % 2 == 1 ? limeColor : blueColor)
                    .rectangle(pageSize.getLeft(), pageSize.getBottom(), pageSize.getWidth(), pageSize.getHeight())
                    .fill().restoreState();

            // appear会出现
            myCanvas.showTextAligned(new Paragraph("Appear"), 100, 400, pdfDoc.getPageNumber(page),
                    TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);
            // appear会出现

            //Add header and footer
            pdfCanvas.beginText()
                    .setFontAndSize(helvetica, 9)
                    .moveText(pageSize.getWidth() / 2 - 60, pageSize.getTop() - 20)
                    .showText("THE TRUTH IS OUT THERE")
                    .moveText(60, -pageSize.getTop() + 30)
                    .showText(String.valueOf(pageNumber))
                    .endText();

            //Add watermark
            // 这个是在背景色之后设置，会出现在背景色上面
            // 如果反过来，就会被背景色覆盖
            Canvas canvas = new Canvas(pdfCanvas, page.getPageSize());
            canvas.setFontColor(ColorConstants.WHITE);
            canvas.setProperty(Property.FONT_SIZE, UnitValue.createPointValue(60));
            canvas.setProperty(Property.FONT, helveticaBold);
            canvas.showTextAligned(new Paragraph("CONFIDENTIAL"), 298, 421, pdfDoc.getPageNumber(page),
                    TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);

            pdfCanvas.release();
        }
    }

}
