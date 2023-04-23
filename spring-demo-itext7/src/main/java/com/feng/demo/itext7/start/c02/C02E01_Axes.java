package com.feng.demo.itext7.start.c02;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author fengyadong
 * @date 2023/4/23 11:37
 * @Description 画坐标系（使用pdf底层api画图）
 */
@Slf4j
public class C02E01_Axes {

    public static final String DEST = "spring-demo-itext7/results/chapter02/1.axes.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C02E01_Axes().createPdf(DEST);
        log.info("success generate pdf 1.axes.pdf");
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        // A4 横向
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);

        PdfCanvas canvas = new PdfCanvas(page);
        //Replace the origin of the coordinate system to the center of the page
        // a   b   0
        // c   d   0
        // e   f   1

        //           (a  b  0)
        // (x,y,1) * (c  d  0) =  (ax+cy+e,bx+dy+f,1) = (x+half_width,y+half_height,1)
        //           (e  f  1)
        // a=1 c=0 e=half_width b=0 d=1f=half_height
        // 改变坐标系
        canvas.concatMatrix(1, 0, 0, 1, ps.getWidth() / 2, ps.getHeight() / 2);

        C02E01_Axes.drawAxes(canvas, ps);

        //Close document
        pdf.close();

    }

    // 在PDF中，所有测量都以用户单位(user unit)完成。 默认情况下，一个用户单位对应一个点。 这意味着在一英寸(one inch)内有72个用户单位。
    // 在PDF中，X轴指向右侧，Y轴指向上。 如果您使用PageSize对象创建页面大小，则坐标系的原点位于页面的左下角。
    // 我们用作操作符（如m或l操作）的操作数的所有坐标都使用此坐标系。 我们可以通过改变当前的变换矩阵来改变坐标系
    public static void drawAxes(PdfCanvas canvas, PageSize ps) {
        //Draw X axis
        // 画x轴 长度：half_width-15
        canvas.moveTo(-(ps.getWidth() / 2 - 15), 0)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .stroke();

        //Draw X axis arrow
        // 画箭头
        canvas.setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(ps.getWidth() / 2 - 25, -10)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .lineTo(ps.getWidth() / 2 - 25, 10).stroke()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.MITER);

        //Draw Y axis
        canvas.moveTo(0, -(ps.getHeight() / 2 - 15))
                .lineTo(0, ps.getHeight() / 2 - 15)
                .stroke();

        //Draw Y axis arrow
        canvas.saveState()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(-10, ps.getHeight() / 2 - 25)
                .lineTo(0, ps.getHeight() / 2 - 15)
                .lineTo(10, ps.getHeight() / 2 - 25).stroke()
                .restoreState();

        //Draw X serif
        // 画刻度线 步进40 刻度半长5
        for (int i = -((int) ps.getWidth() / 2 - 61); i < ((int) ps.getWidth() / 2 - 60); i += 40) {
            canvas.moveTo(i, 5).lineTo(i, -5);
        }
        //Draw Y serif
        for (int j = -((int) ps.getHeight() / 2 - 57); j < ((int) ps.getHeight() / 2 - 56); j += 40) {
            canvas.moveTo(5, j).lineTo(-5, j);
        }
        canvas.stroke();

    }

}
