package com.feng.demo.pdfbox.start;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

/**
 * @author fengyadong
 * @date 2023/4/24 14:26
 * @Description
 */
@Slf4j
public class HelloWorld {

    public static final String DEST = "spring-demo-pdfbox/result/start/1.HelloWorld.pdf";

    public static void main(String[] args) throws IOException {

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        HelloWorld.createPdf(DEST);
    }

    private static void createPdf(String dest) throws IOException {
        //Creating PDF document object
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        //Saving the document
        document.save(DEST);

        System.out.println("PDF created");

        //Closing the document
        document.close();
    }

}
