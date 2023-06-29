package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.util.FontUtil;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class TextSample2 {


    public static void main(String[] args) {

        String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
        sample(fileName);

    }


    public static void sample(String fileName) {

        try {
            Document document = new Document();
            document.setMargins(71, 70, 20, 10);
            PdfWriter writer = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));


            Font font = FontUtil.getFont();

            HeaderFooter footer = new HeaderFooter(new Phrase("页码：", font), true);
            footer.setAlignment(HeaderFooter.ALIGN_CENTER);
            footer.setBorder(Rectangle.NO_BORDER);
            document.setFooter(footer);


            document.open();

            PdfContentByte cb = writer.getDirectContent();


//			font.getBaseFont().getWidth()
//			font.getSize()

            ColumnText ct = new ColumnText(cb);
            Chunk c1 = new Chunk("我爱中国", FontUtil.getFont());
            c1.setUnderline(Color.green, 1, 0, 0, 0, 0);
            Phrase phrase = new Phrase(c1);
            ct.setText(phrase);
            float width = ColumnText.getWidth(phrase);
            System.out.println("宽度为：" + width);
            ct.setSimpleColumn(10, 330, width + 10, 450);
            ct.setSimpleColumn(10, 330, 1000, 450);
            ct.go();

            document.close();


            System.out.println("运行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static float getMaxFontSize(BaseFont bf, String text, int width) {
        int textWidth = bf.getWidth(text);

        return (1000 * width) / textWidth;
    }


}
