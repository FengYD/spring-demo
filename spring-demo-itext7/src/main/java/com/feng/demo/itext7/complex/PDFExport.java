package com.feng.demo.itext7.complex;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author fengyadong
 * @date 2023/4/23 16:42
 * @Description
 */
@Slf4j
public class PDFExport {

    private static final String Song = "宋体";
    private static final String FangSong = "仿宋";
    private static final String HuaWen = "华文仿宋";

    private static PdfFont fontSong;
    private static PdfFont fontFangSong;
    private static PdfFont fontHuaWen;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
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
        Paragraph header1 = new Paragraph(model.getSendManDeptName())
                .setFont(fontSong).setFontSize(22).setBold()
                .setTextAlignment(TextAlignment.CENTER);
        Paragraph header2 = new Paragraph("协助提供数据函")
                .setFont(fontSong).setFontSize(22).setBold()
                .setTextAlignment(TextAlignment.CENTER);
        Paragraph assistLetterNo = new Paragraph(model.getAssistLetterNo())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.RIGHT);
        document.add(header1).add(header2).add(assistLetterNo);

        Paragraph p1 = new Paragraph(model.getAssistPlatEntityName())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT);
        Paragraph p2 = new Paragraph(model.getAssistReason())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT)
                .setFirstLineIndent(32);
        Paragraph p3 = new Paragraph("涉案信息如下：")
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT)
                .setFirstLineIndent(32);
        Paragraph p4 = new Paragraph("查询范围：" + model.getAssistScopeName())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT)
                .setFirstLineIndent(32);
        document.add(p1).add(p2).add(p3).add(p4);
        for (AssistLetterExportModel.KVData kvData : model.getAssistProvideDataVO()) {
            Paragraph p = new Paragraph(kvData.getKey() + "：" + kvData.getValue())
                    .setFont(fontFangSong).setFontSize(16)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFirstLineIndent(32);
            document.add(p);
        }
        Paragraph p5 = new Paragraph("请你单位在收到本函后予以协助，于" + model.getAssistLimit() +
                "内（一般为收到函件的10个工作日）内反馈调查结果。（反馈调查结果数据见附件1）需要延期完成的，请在期限届满" +
                "前告知本局。请提供以上事项的相关数据信息，并及时将结果回复至" + model.getSendManDeptName() + "。")
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT)
                .setFirstLineIndent(32);
        Paragraph p6 = new Paragraph("联系人：" + model.getSendUserName())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT)
                .setFirstLineIndent(32);
        Paragraph p7 = new Paragraph("联系电话：" + model.getSendUserPhone())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT)
                .setFirstLineIndent(32);
        document.add(p5).add(p6).add(p7);
        Paragraph p8 = new Paragraph(model.getSendManDeptName())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.RIGHT);
        Paragraph p9 = new Paragraph("（盖章）")
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.RIGHT);
        Paragraph p10 = new Paragraph(model.getSendTime())
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.RIGHT);
        document.add(p8).add(p9).add(p10);
        // 分页
        document.add(new AreaBreak());
        Paragraph p11 = new Paragraph("附件1")
                .setFont(fontFangSong).setFontSize(16)
                .setTextAlignment(TextAlignment.LEFT);
        document.add(p11);
        for (int i = 1; i <= model.getAssistReplyDataVO().size(); i++) {
            AssistLetterExportModel.AssistPlatScopeVO vo = model.getAssistReplyDataVO().get(i - 1);
            Paragraph tableName = new Paragraph(i + "." + vo.getAssistScopeName())
                    .setFont(fontFangSong).setFontSize(16)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFirstLineIndent(32);
            document.add(tableName);
            Table table = new Table(new float[]{4, 6}).useAllAvailableWidth().setMarginLeft(32);
            Color blueColor = new DeviceRgb(153,204,255);
            Paragraph tableHeader1 = new Paragraph("数据类别")
                    .setFont(fontHuaWen).setFontSize(12)
                    .setBackgroundColor(blueColor)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().setBackgroundColor(blueColor).add(tableHeader1));
            Paragraph tableHeader2 = new Paragraph("具体数据项")
                    .setFont(fontHuaWen).setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().setBackgroundColor(blueColor).add(tableHeader2));
            Map<String, List<String>> tempMap = new LinkedHashMap<>();
            for (AssistLetterExportModel.AssistPlatReplyVO replyVO : vo.getAssistPlatReplyVOList()) {
                if (tempMap.containsKey(replyVO.getAssistReplyType())) {
                    tempMap.get(replyVO.getAssistReplyType()).add(replyVO.getAssistReplyName());
                } else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(replyVO.getAssistReplyName());
                    tempMap.put(replyVO.getAssistReplyType(), tempList);
                }
            }
            for (String tempKey : tempMap.keySet()) {
                List<String> tempList = tempMap.get(tempKey);
                Paragraph type = new Paragraph(tempKey)
                        .setFont(fontFangSong).setFontSize(12)
                        .setTextAlignment(TextAlignment.LEFT);
                Cell cell;
                if (tempList.size() > 1) {
                    cell = new Cell(tempList.size(), 1).add(type).setVerticalAlignment(VerticalAlignment.MIDDLE);
                } else {
                    cell = new Cell().add(type).setVerticalAlignment(VerticalAlignment.MIDDLE);
                }
                table.addCell(cell);
                tempList.forEach(
                        e -> {
                            Paragraph name = new Paragraph(e)
                                    .setFont(fontFangSong).setFontSize(12)
                                    .setTextAlignment(TextAlignment.LEFT);
                            Cell cellName = new Cell().add(name).setVerticalAlignment(VerticalAlignment.MIDDLE);
                            table.addCell(cellName);
                        }
                );
            }
            document.add(table);
        }
        pdf.close();
        long endTime = System.currentTimeMillis();
        log.info("cost time {} ms", endTime - startTime);
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
                null, "贝贝网的文件系统管理员贝贝网的TYPE1", "贝贝网的文件");
        AssistLetterExportModel.AssistPlatReplyVO vo1 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的TYPE1", "贝贝网的文件贝贝网");
        AssistLetterExportModel.AssistPlatReplyVO vo2 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的TYPE1", "贝贝网的文");
        AssistLetterExportModel.AssistPlatReplyVO vo3 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件系统管理员贝贝网的TYPE1", "贝贝网的");
        AssistLetterExportModel.AssistPlatReplyVO vo4 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝TYPE2", "贝贝网的文件");
        AssistLetterExportModel.AssistPlatReplyVO vo5 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝TYPE3", "贝贝网的");
        AssistLetterExportModel.AssistPlatReplyVO vo6 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝TYPE3", "贝贝网的");
        AssistLetterExportModel.AssistPlatReplyVO vo7 = new AssistLetterExportModel.AssistPlatReplyVO(
                null, "贝贝网的文件贝贝TYPE3", "贝贝网的文件");
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
