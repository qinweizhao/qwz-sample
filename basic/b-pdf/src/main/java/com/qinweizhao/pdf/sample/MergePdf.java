package com.qinweizhao.pdf.sample;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.pdf.util.FontUtil;
import com.qinweizhao.pdf.util.PdfUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class MergePdf {


    public static void main(String[] args) {

        String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
//        sample(fileName);2

//        PdfUtils.extract("/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/1685501417911.pdf",fileName, Arrays.asList(2));
//

        merge(fileName);

    }


    public static void merge(String fileName) {

        try {
//            Document document = new Document(PageSize.A4);
//            document.setMargins(70, 70, 20, 10);
//            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));
//            Font font = FontUtil.getFont();
//
//
//            HeaderFooter footer = new HeaderFooter(new Phrase("页码：", font), true);
//            footer.setAlignment(HeaderFooter.ALIGN_CENTER);
//            footer.setBorder(Rectangle.NO_BORDER);
//            document.setFooter(footer);
//            document.open();
//
//            Phrase ph = new Phrase();
//            ph.add(new Chunk("第一页", font));
//            document.add(ph);
//
////            document.newPage();
////            document.setPageSize(PageSize.A4);
            String sourceFile = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/1685501406240.pdf";
            PdfUtils.extract(sourceFile, fileName, Collections.singletonList(2));
//            document.close();


            System.out.println("运行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void test(String fileName) {

        try {
            Document document = new Document(PageSize.A4);
            document.setMargins(70, 70, 20, 10);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));
            Font font = FontUtil.getFont();
            PdfDocument pdf = new PdfDocument();
            pdf.addWriter(pdfWriter);
            String targetFile = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/1685501406240.pdf";


            HeaderFooter footer = new HeaderFooter(new Phrase("页码：", font), true);
            footer.setAlignment(HeaderFooter.ALIGN_CENTER);
            footer.setBorder(Rectangle.NO_BORDER);
            document.setFooter(footer);
            document.open();

            Phrase ph = new Phrase();
            ph.add(new Chunk("第一页", font));
            document.add(ph);


            PdfUtils.extract(targetFile, fileName, Collections.singletonList(2));

            document.newPage();
            document.setPageSize(PageSize.A3);

            PdfDocument pdfDocument = new PdfDocument();
            PdfReader pdfReader = new PdfReader(targetFile);




            byte[] pageContent = pdfReader.getPageContent(2);
            System.out.println("pageContent = " + pageContent);
            document.add(new Phrase(new String(pageContent)));

            document.close();


            System.out.println("运行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
