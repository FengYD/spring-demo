package com.feng.demo.itext7.complex;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fengyadong
 * @date 2023/4/23 16:42
 * @Description
 */
public class PDFExport {

    private static final String Song = "宋体";
    private static final String FangSong = "仿宋";
    private static final String HuaWen = "华文仿宋";

    private static PdfFont fontSong;
    private static PdfFont fontFangSong;
    private static PdfFont fontHuaWen;

    public static void main(String[] args) throws IOException {
        loadFonts();
        AssistLetterExportModel model = buildModel();
        String dest = "spring-demo-itext7/results/" + model.getSendManDeptName() + "（" + model.getAssistLetterNo() + "）.pdf";
        File file = new File(dest);
        file.getParentFile().mkdirs();
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf, PageSize.A4);
        document.setTopMargin(102);
        document.setBottomMargin(96);
        document.setLeftMargin(79);
        document.setRightMargin(74);
        Paragraph header1 = new Paragraph(model.getSendManDeptName()).setFont(fontSong).setFontSize(16).setTextAlignment(TextAlignment.CENTER);
        Paragraph header2 = new Paragraph("协助提供数据函").setFont(fontSong).setFontSize(16).setTextAlignment(TextAlignment.CENTER);
        Paragraph assistLetterNo = new Paragraph(model.getSendManDeptName()).setFont(fontFangSong).setFontSize(14).setTextAlignment(TextAlignment.RIGHT);
        document.add(header1).add(header2).add(assistLetterNo);
        pdf.close();
    }

    private static void loadFonts() throws IOException {
        String os = System.getProperty("os.name");
        boolean isWin = false;
        if (os != null && os.toLowerCase().startsWith("windows")) {
            isWin = true;
        }
        if (isWin) {
            PdfFontFactory.registerSystemDirectories();
        } else {
            PdfFontFactory.registerDirectory("/usr/share/fonts/myfonts");
        }
        fontSong = PdfFontFactory.createRegisteredFont(Song);
        fontFangSong = PdfFontFactory.createRegisteredFont(FangSong);
        fontHuaWen = PdfFontFactory.createRegisteredFont(HuaWen);
    }

    private static AssistLetterExportModel buildModel() {
        AssistLetterExportModel model = new AssistLetterExportModel();
        model.setSendManDeptName("XXX监督管理局");
        model.setAssistLetterNo("12322222222");
        model.setAssistPlatEntityName("深圳市XX计算机系统有限公司");
        model.setAssistReason("系统管理员给贝贝网的文件系统管理员给贝贝网的文件系统管理员给贝贝网的文件。");
        model.setAssistScopeName("文件文件/文件文件文件/文件");
        model.setAssistLimit("10个工作日");
        model.setSendUserName("系统管理员");
        model.setSendUserPhone("13222222222");
        model.setSendTime("2023年04月23日");
        model.setAssistProvideDataVO(new ArrayList<>());
        AssistLetterExportModel.KVData kvData = new AssistLetterExportModel.KVData("联系人", "1111");
        model.getAssistProvideDataVO().add(kvData);
        AssistLetterExportModel.AssistPlatReplyVO vo = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的文件", "贝贝网的文件");
        AssistLetterExportModel.AssistPlatReplyVO vo1 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的文件", "贝贝网的文件贝贝网");
        AssistLetterExportModel.AssistPlatReplyVO vo2 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的文件", "贝贝网的文");
        AssistLetterExportModel.AssistPlatReplyVO vo3 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的文件", "贝贝网的");
        AssistLetterExportModel.AssistPlatReplyVO vo4 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝", "贝贝网的文件");
        AssistLetterExportModel.AssistPlatReplyVO vo5 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝", "贝贝网的");
        AssistLetterExportModel.AssistPlatReplyVO vo6 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝", "贝贝网的");
        AssistLetterExportModel.AssistPlatReplyVO vo7 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝", "贝贝网的文件");
        List<AssistLetterExportModel.AssistPlatReplyVO> list = new ArrayList<>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        list.add(vo5);
        list.add(vo6);
        list.add(vo7);
        AssistLetterExportModel.AssistPlatScopeVO scopeVO = new AssistLetterExportModel.AssistPlatScopeVO(
                null, "贝贝网", list);
        model.setAssistReplyDataVO(Collections.singletonList(scopeVO));
        return model;
    }

}
