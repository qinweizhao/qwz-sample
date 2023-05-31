package com.qinweizhao.pdf.sample;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.pdf.util.FontUtil;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class ReadPdf {


    public static void main(String[] args) {

        String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
//        sample(fileName);

        readPdfByPage("/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/1685427180574.pdf",0,1);

    }


    public static void sample(String fileName) {

        try {
            Document document = new Document(PageSize.A4);
            document.setMargins(70, 70, 20, 10);
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));
            Font font = FontUtil.getFont();


            HeaderFooter footer = new HeaderFooter(new Phrase("页码：", font), true);
            footer.setAlignment(HeaderFooter.ALIGN_CENTER);
            footer.setBorder(Rectangle.NO_BORDER);
            document.setFooter(footer);
            document.open();

            document.close();


            System.out.println("运行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String readPdfByPage(String fileName, int from, int end) {
        String result = "";
        File file = new File(fileName);




        try (FileInputStream in = new FileInputStream(fileName)) {
            // 新建一个PDF解析器对象
            PdfReader reader = new PdfReader(fileName);
            reader.setAppendable(false);
            // 对PDF文件进行解析，获取PDF文档页码
            int size = reader.getNumberOfPages();
            for (int i = from; i <= end && i < size; i++) {


                int numberOfPages = reader.getNumberOfPages();
                System.out.println("numberOfPages" + numberOfPages);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("读取PDF文件" + file.getAbsolutePath() + "生失败！" + e);
            e.printStackTrace();
        }
        return result;
    }


}
