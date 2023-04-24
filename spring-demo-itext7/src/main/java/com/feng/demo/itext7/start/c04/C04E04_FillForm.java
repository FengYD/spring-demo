package com.feng.demo.itext7.start.c04;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author fengyadong
 * @date 2023/4/24 17:49
 * @Description 读取pdf预设模板，填充值
 */
@Slf4j
public class C04E04_FillForm {

    public static final String SRC = "spring-demo-itext7/results/chapter04/5.job_application.pdf";
    public static final String DEST = "spring-demo-itext7/results/chapter04/7.fill_form.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C04E04_FillForm().manipulatePdf(SRC, DEST);
        log.info("success generate pdf 7.fill_form.pdf");
    }

    public void manipulatePdf(String src, String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfReader(src), new PdfWriter(dest));

        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        fields.get("name").setValue("James Bond");
        fields.get("language").setValue("English");
        fields.get("experience1").setValue("Off");
        fields.get("experience2").setValue("Yes");
        fields.get("experience3").setValue("Yes");
        fields.get("shift").setValue("Any");
        fields.get("info").setValue("I was 38 years old when I became an MI6 agent.");

        pdf.close();

    }
}
